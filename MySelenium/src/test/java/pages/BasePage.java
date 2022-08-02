package pages;

import component.Locator;
import org.openqa.selenium.By;

public class BasePage {

    public Locator locator;

    public BasePage(Locator locator) {
        this.locator = locator;
    }

    public BasePage() {
    }

    public Locator getLocatorByXpath(String byXpath1) {
        return new Locator(By.xpath(byXpath1), this.locator);
    }

    public Locator getLocatorByCss(String css) {
        return new Locator(By.cssSelector(css), this.locator);
    }

}
