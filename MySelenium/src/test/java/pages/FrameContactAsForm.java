package pages;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;
import pages.helpers.ContactFormTopicType;
import pages.helpers.Form;
import pages.helpers.StringHelper;

public class FrameContactAsForm extends BasePage {

    public Locator titleOfQuestion = getLocatorByXpath("//div[contains(@class,'formio-component-TopicArea')]");
    public Locator inputTitle = getLocatorByXpath("(//input[@class='choices__input choices__input--cloned'])[1]");
    public Locator firstTitleInList = getLocatorByXpath("(//div[contains(@class,'choices__item choices__item--choice choices__item--selectable')])[1]");
    public Locator writeText = getLocatorByXpath("//div[@class='swf-textarea-editor']");
    public Locator firstName = getLocatorByCss("#FirstName");
    public Locator lastName = getLocatorByCss("#LastName");
    public Locator emailAddress = getLocatorByCss("#Email");
    public Locator companyName = getLocatorByCss("#CompanyName");
    public Locator lineRelationship = getLocatorByXpath("//div[contains(@class,'formio-component-RelationshipToSAP')]");

    public FrameContactAsForm() {
        super(new Locator(By.xpath("//iframe[@class='html-content-lightbox-frame']"), true));
    }

    public void chooseTitleOfQuestion(ContactFormTopicType contactFormTopicType) {
        Driver.getDriver().click(titleOfQuestion);
        Driver.getDriver().enterText(inputTitle, contactFormTopicType.toString());
        Driver.getDriver().click(firstTitleInList);
    }

    public void enterYourPersonalDetails(Form form) {
        enterFirstName(form);
        enterLastName(form);
        enterMail(form);
        enterCompanyName(form);
    }

    public void enterYourText() {
        Driver.getDriver().enterText(writeText, new StringHelper().generatedString);
    }

    public void enterFirstName(Form form) {
        Driver.getDriver().enterText(firstName, form.firstName);
    }

    public void enterLastName(Form form) {
        Driver.getDriver().enterText(lastName, form.lastName);
    }

    public void enterCompanyName(Form form) {
        Driver.getDriver().enterText(companyName, form.companyName);
    }

    public void enterMail(Form form) {
        Driver.getDriver().enterText(emailAddress, form.mail);
    }

}
