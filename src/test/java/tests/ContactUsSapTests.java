package tests;

import data.PageUrls;
import io.qameta.allure.Step;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;
import pages.contactUs.ContactUsWidget;
import pages.WebSiteNavigator;
import pages.contactUs.ContactUsForm;
import pages.contactUs.helpers.RelationshipToSap;
import pages.contactUs.helpers.Topic;
import pages.contactUs.helpers.Form;
import settings.RetryAnalyzer;

public class ContactUsSapTests extends BaseTest {

    private ContactUsWidget contactUsWidget;
    private WebSiteNavigator navigationSap;
    private ContactUsForm contactUsForm;
    private Form form;

    public ContactUsSapTests() {
        contactUsWidget = new ContactUsWidget();
        navigationSap = new WebSiteNavigator();
        contactUsForm = new ContactUsForm();
        form = Form.builder()
                .firstName("Yevhenii")
                .lastName("Hurov")
                .mail("gurov@gmail.com")
                .companyName("HurovAndCompany")
                .topic(Topic.Podpora)
                .relationshipToSap(RelationshipToSap.Partner)
                .build();
    }

    @Step
    @Test()
    public void checkContactForm() {
        navigationSap.openSapPageAndAcceptCookies(PageUrls.INDEX_URL);
        contactUsWidget.openFrameContactForm();
        contactUsForm.fillForm(form, RandomString.make(25));
        // Verify was not added not to submit test data for production
    }

}
