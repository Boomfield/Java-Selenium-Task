package steps;

import component.Locator;
import pages.tutorialPage.TutorialPage;
import wait.Waiter;

import static driver.Driver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TutorialSteps {

    private TutorialPage tutorialPage = new TutorialPage();

    public void verifyStepNumberIsViewport(int stepNumber) {
        Locator inViewport = tutorialPage.getTutorialStep(stepNumber).titleLabel;
        Waiter.wait(() -> getDriver().isVisibleInViewport(inViewport), 3);

        assertThat(getDriver().isVisibleInViewport(inViewport), is(true));
    }

    public void verifyStepTutorialIsOpen(int stepNumber) {
        assertThat(tutorialPage.getTutorialStep(stepNumber).isStepExpanded(), is(true));
    }
}
