package tests;

import org.testng.annotations.Test;
import pages.FrameContactAsForm;
import pages.NavigationSap;
import pages.NavigatorPage;
import pages.SapPage;
import pages.helpers.ContactFormTopicType;
import pages.helpers.Form;

public class TestSapPage extends BaseTest {

    private SapPage sapPage;
    private NavigationSap navigationSap;
    private FrameContactAsForm frameContactAsForm;
    private Form form;

    public TestSapPage() {
        sapPage = new SapPage();
        navigationSap = new NavigationSap();
        frameContactAsForm = new FrameContactAsForm();
        form = new Form("Yevhenii", "Hurov", "gurov@gmail.com", "HurovAndCompany");
    }

    @Test
    public void checkContactForm() {
        navigationSap.openSapPageAndAcceptCookies();
        sapPage.openFrameContactForm();
        frameContactAsForm.chooseTitleOfQuestion(ContactFormTopicType.Events);
        frameContactAsForm.enterYourText();
        frameContactAsForm.enterYourPersonalDetails(form);

    }
}
