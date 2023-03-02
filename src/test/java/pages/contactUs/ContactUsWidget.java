package pages.contactUs;

import component.Locator;
import pages.BasePage;

import static driver.Driver.getDriver;

public class ContactUsWidget extends BasePage {

    public Locator collapsedSection = getByXpath("//div[contains(@class,'Flyout__opener')]");
    public Locator formOpenLink = getByXpath("//a[contains(@class,'Title__titleInContactModule')]");

    public void openFrameContactForm() {
        getDriver().click(collapsedSection);
        getDriver().click(formOpenLink);
    }

}
