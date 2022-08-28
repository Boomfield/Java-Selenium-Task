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

    public Locator getByXpath(String xpath) {
        return new Locator(By.xpath(xpath), this.locator);
    }

    public Locator getByCss(String css) {
        return new Locator(By.cssSelector(css), this.locator);
    }

}
