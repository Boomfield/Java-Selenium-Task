package tests;

import data.PageUrls;
import org.testng.annotations.Test;
import pages.WebSiteNavigator;
import pages.tutorialPage.TutorialPage;
import steps.TutorialSteps;

public class TutorialPageTests extends BaseTest {

    private TutorialPage tutorialPage;
    private TutorialSteps tutorialSteps;
    private WebSiteNavigator navigationSap;

    public TutorialPageTests() {
        tutorialPage = new TutorialPage();
        tutorialSteps = new TutorialSteps();
        navigationSap = new WebSiteNavigator();
    }

    @Test()
    public void checkTitlePageOnSteps() {
        int stepNumber = 3;
        navigationSap.openNavigatorPageAndAcceptCookies(PageUrls.STEP_TUTORIALS);

        tutorialPage.getStepTutorials(1).waitLoadStep();
        tutorialPage.clickTitleStepsByNumber(stepNumber);

        tutorialSteps.verifyStepTutorialIsOpen(stepNumber);
        tutorialSteps.verifyStepNumberIsViewport(stepNumber);
    }
}
