package driver;

import component.Locator;
import driver.config.BaseDriverConfig;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;

import static java.util.stream.Collectors.toCollection;

public class Driver {

    private WebDriver driver;
    private BaseDriverConfig config;
    private By currentFrame = null;
    public static ThreadLocal<Driver> instance = new ThreadLocal<>();

    public WebDriver getNativeDriver() {
        if (driver == null) {
            driver = config.createDriver(System.getenv("CHROME_DRIVER"));
        }
        return driver;
    }

    public Driver(BaseDriverConfig config) {
        this.config = config;
    }

    public static Driver getDriver() {
        return instance.get();
    }

    public void addCookies(Cookie cookie) {
        getDriver().driver.manage().addCookie(cookie);
    }

    public void navigate(String url) {
        getNativeDriver().navigate().to(url);
    }

    public SearchContext findParent(Locator locator) {
        if (locator.parent != null) {
            if (locator.parent.iFrame) {
                if (currentFrame == null || !currentFrame.equals(locator.parent.element)) {
                    switchTo(locator.parent.element);
                    currentFrame = locator.parent.element;
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

    public ArrayList<String> getElementsText(Locator locator) {
        ArrayList<String> elements = findElements(locator)
                .stream().map(x -> x.getText()).collect(toCollection(ArrayList::new));
        return elements;
    }

    public void click(Locator locator) {
        WebElement button = findElement(locator);
        button.click();
    }

    public void switchTo(By by) {
        driver.switchTo().frame(driver.findElement(by));
    }

    public void clickByText(Locator locator, String text) {
        Optional<WebElement> element = findElements(locator)
                .stream().filter(x -> x.getAttribute("textContent").trim().equals(text)).findFirst();
        element.get().click();
    }

    public void clickElementByIndex(int index, Locator locator) {
        ArrayList<WebElement> elements = findElements(locator);
        elements.get(index).click();
    }

    public void enterText(Locator locator, String text) {
        WebElement element = findElement(locator);
        element.sendKeys(text);
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
