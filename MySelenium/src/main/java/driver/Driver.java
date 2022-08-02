package driver;

import component.Locator;
import driver.config.BaseDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;

import static java.util.stream.Collectors.toCollection;

public class Driver {

    private WebDriver driver;
    private BaseDriverConfig config;
    private By firstIFrame = null;
    public static ThreadLocal<Driver> instance = new ThreadLocal<>();

    public WebDriver getNativeDriver() {
        if (driver == null) {
            driver = config.createDriver(System.getenv("CHROME_DRIVER"));
        }
        return driver;
    }

    public static Driver getDriver() {
        return Driver.instance.get();
    }

    public Driver(BaseDriverConfig config) {
        this.config = config;
    }

    public void navigate(String url) {
        getNativeDriver().navigate().to(url);
    }

    public SearchContext findParent(Locator locator) {
        if (locator.parent != null) {
            if (locator.parent.iFrame) {
                if (firstIFrame == null || !firstIFrame.equals(locator.parent.element)) {
                    switchTo(locator.parent.element);
                    firstIFrame = locator.parent.element;
                }
                return driver;
            } else {
                driver.switchTo().defaultContent();
                return driver.findElement(locator.parent.element);
            }
        } else {
            driver.switchTo().defaultContent();
            return driver;
        }
    }


    public WebElement findElement(Locator locator) {
        return findParent(locator).findElement(locator.element);
    }

    public ArrayList<WebElement> findElements(Locator locator) {
        return (ArrayList<WebElement>) findParent(locator).findElements(locator.element);
    }

    public ArrayList<String> getResultTextList(Locator locator) {
        ArrayList<String> listResult = findElements(locator)
                .stream().map(x -> x.getText()).collect(toCollection(ArrayList::new));
        return listResult;
    }

    public void click(Locator locator) {
        WebElement button = findElement(locator);
        button.click();
    }

    public void switchTo(By by) {
        driver.switchTo().frame(driver.findElement(by));
    }

    public void clickByText(Locator locator, String text) {
        Optional<WebElement> element = Driver.getDriver().findElements(locator)
                .stream().filter(x -> x.getText().equals(text)).findFirst();
        element.get().click();
    }

    public void clickPaginationByIndex(int index, Locator locator) {
        ArrayList<WebElement> listAllNumberPageLink = Driver.getDriver().findElements(locator);
        listAllNumberPageLink.get(index).click();
    }

    public void enterText(Locator locator, String text) {
        WebElement search = findElement(locator);
        search.sendKeys(text);
    }

    public boolean exist(Locator locator) {
        try {
            getNativeDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            return getNativeDriver().findElement(locator.element) != null;
        } catch (Exception ex) {
            return false;
        } finally {
            getNativeDriver().manage().timeouts().implicitlyWait(config.timeElementWait);
        }
    }

    public void close() {
        getNativeDriver().close();
    }

}
