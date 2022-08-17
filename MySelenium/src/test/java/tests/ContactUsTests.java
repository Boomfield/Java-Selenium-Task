package tests;

import org.testng.annotations.Test;
import pages.contactUs.ContactUsWidget;
import pages.PageAndCookie;
import pages.contactUs.ContactUsForm;
import pages.contactUs.helpers.ContactFormRelationshipToSap;
import pages.contactUs.helpers.ContactFormTopicType;
import pages.contactUs.helpers.Form;

public class ContactUsTests extends BaseTest {

    private ContactUsWidget sapPage;
    private PageAndCookie navigationSap;
    private ContactUsForm contactUsForm;
    private Form form;

    public ContactUsTests() {
        sapPage = new ContactUsWidget();
        navigationSap = new PageAndCookie();
        contactUsForm = new ContactUsForm();
        form = new Form("Yevhenii", "Hurov", "gurov@gmail.com", "HurovAndCompany");
    }

    @Test
    public void checkContactForm() {
        navigationSap.openSapPageAndAcceptCookies();
        sapPage.openFrameContactForm();
        contactUsForm.chooseTitleOfQuestion(ContactFormTopicType.Podpora);
        contactUsForm.enterYourText();
        contactUsForm.enterYourPersonalDetails(form);
        contactUsForm.chooseRelationshipToSap(ContactFormRelationshipToSap.Partner);
        // Verify was not added not to submit test data for production
    }
}
