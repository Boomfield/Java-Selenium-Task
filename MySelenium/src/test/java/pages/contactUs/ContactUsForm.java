package pages.contactUs;

import component.Locator;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.contactUs.helpers.ContactFormRelationshipToSap;
import pages.contactUs.helpers.ContactFormTopicType;
import helpers.StringHelper;
import pages.contactUs.helpers.Form;
import wait.Waiter;

import static driver.Driver.getDriver;

public class ContactUsForm extends BasePage {

    public Locator topicDropdown = getByXpath(".//div[contains(@class,'formio-component-TopicArea')]");
    public Locator inputTitle = getByXpath("(//input[@class='choices__input choices__input--cloned'])[1]");
    public Locator firstTitleInList = getByXpath("//div[contains(@class,'choices__item choices__item--choice choices__item--selectable')]");
    public Locator writeText = getByXpath("//div[@class='swf-textarea-editor']");
    public Locator firstNameInput = getByCss("#FirstName");
    public Locator lastNameInput = getByCss("#LastName");
    public Locator emailAddressInput = getByCss("#Email");
    public Locator companyNameInput = getByCss("#CompanyName");
    public Locator relationshipToSapDropdown = getByXpath("//div[contains(@Class, 'ormio-component-RelationshipToSAP')]");
    public Locator relationshipToSapItemChoice = getByXpath("//div[contains(@id,'choices--RelationshipToSAP-item-choice')]");

    public ContactUsForm() {
        super(new Locator(By.xpath("//iframe[@class='html-content-lightbox-frame']"), true));
    }

    public void chooseTitleOfQuestion(ContactFormTopicType contactFormTopicType) {
        Waiter.waitNoError(() -> getDriver().click(topicDropdown));
        getDriver().enterText(inputTitle, contactFormTopicType.toString());
        getDriver().click(firstTitleInList);
    }

    public void enterYourPersonalDetails(Form form) {
        enterFirstName(form.firstName);
        enterLastName(form.lastName);
        enterMail(form.mail);
        enterCompanyName(form.companyName);
    }

    public void enterYourText() {
        getDriver().enterText(writeText, new StringHelper().generatedString);
    }

    public void chooseRelationshipToSap(ContactFormRelationshipToSap contactFormRelationshipToSap) {
        getDriver().click(relationshipToSapDropdown);
        getDriver().clickByText(relationshipToSapItemChoice, contactFormRelationshipToSap.toString());
    }

    public void enterFirstName(String firstName) {
        getDriver().enterText(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        getDriver().enterText(lastNameInput, lastName);
    }

    public void enterCompanyName(String companyName) {
        getDriver().enterText(companyNameInput, companyName);
    }

    public void enterMail(String email) {
        getDriver().enterText(emailAddressInput, email);
    }

}
