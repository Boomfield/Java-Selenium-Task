package pages;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;

import static driver.Driver.getDriver;

public class SapPage extends BasePage {

    public Locator contactContainer = getLocatorByXpath("//div[contains(@class,'Flyout__opener')]");
    public Locator contactForm = getLocatorByXpath("//a[contains(@class,'Title__titleInContactModule')]");
    public Locator closeContactForm = getLocatorByXpath("//div[@class='toolbtn exit icon-close mfp-close']");

    public void openFrameContactForm() {
        getDriver().click(contactContainer);
        getDriver().click(contactForm);
    }

}
