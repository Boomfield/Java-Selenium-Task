package steps;

import pages.tutorialPage.TutorialPage;
import wait.Waiter;

import static driver.Driver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TutorialSteps {

    private TutorialPage tutorialPage = new TutorialPage();

    public void verifyStepNumberIsViewport(int stepNumber) {
        boolean inViewport = getDriver().isVisibleInViewport(tutorialPage.getStepTutorials(stepNumber).titleLabel);
        Waiter.wait(() -> inViewport, 3);

        assertThat(inViewport, is(true));
    }

    public void verifyStepTutorialIsOpen(int stepNumber) {
        assertThat(tutorialPage.getStepTutorials(stepNumber).isStepExpanded(), is(true));
    }
}
