package pages.contactUs;

import component.Locator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.contactUs.helpers.RelationshipToSap;
import pages.contactUs.helpers.Topic;
import pages.contactUs.helpers.Form;
import wait.Waiter;

import static driver.Driver.getDriver;

public class ContactUsForm extends BasePage {

    public Locator topicDropdown = getByXpath(".//div[contains(@class,'formio-component-TopicArea')]");
    public Locator titleInput = getByXpath(".//div[contains(@Class, 'TopicArea')]//input[@Class]");
    public Locator topicAreaListOption = getByXpath(".//div[contains(@class,'choices__item choices__item--choice choices__item--selectable')]");
    public Locator writeTextInput = getByXpath(".//div[@class='swf-textarea-editor']");
    public Locator firstNameInput = getByCss("#FirstName");
    public Locator lastNameInput = getByCss("#LastName");
    public Locator emailAddressInput = getByCss("#Email");
    public Locator companyNameInput = getByCss("#CompanyName");
    public Locator relationshipToSapDropdown = getByXpath(".//div[contains(@Class, 'ormio-component-RelationshipToSAP')]");
    public Locator relationshipToSapOption = getByXpath(".//div[contains(@id,'choices--RelationshipToSAP-item-choice')]");

    public ContactUsForm() {
        super(new Locator(By.xpath("//iframe[@class='html-content-lightbox-frame']"), true));
    }

    public void chooseTopic(Topic contactFormTopicType) {
        Waiter.waitNoError(() -> getDriver().click(topicDropdown));

        getDriver().enterText(titleInput, contactFormTopicType.toString());
        getDriver().click(topicAreaListOption);
    }

    @Step
    public void fillForm(Form form,String message) {
        chooseTopic(form.topic);
        enterMessage(message);
        enterFirstName(form.firstName);
        enterLastName(form.lastName);
        enterMail(form.mail);
        enterCompanyName(form.companyName);
        chooseRelationshipToSap(form.relationshipToSap);
    }

    public void enterMessage(String message) {
        getDriver().enterText(writeTextInput, message);
    }

    public void chooseRelationshipToSap(RelationshipToSap contactFormRelationshipToSap) {
        getDriver().click(relationshipToSapDropdown);
        getDriver().clickByText(relationshipToSapOption, contactFormRelationshipToSap.toString());
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
