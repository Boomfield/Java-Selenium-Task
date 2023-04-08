package pages.tutorialNavigator;

import component.Locator;
import pages.BasePage;
import pages.tutorialNavigator.component.StepTutorials;
import wait.Waiter;

import static driver.Driver.getDriver;

public class TitlePage extends BasePage {
    public Locator titleSteps = getByXpath("//div[contains(@class,'TutorialSideBar__linkText')]");
    public StepTutorials stepTutorials = new StepTutorials();

    public TitlePage(Locator locator) {
        super(locator);
    }

    public TitlePage() {
    }

    public StepTutorials getStepTutorials(int index) {
        return new StepTutorials(index);
    }

    public void clickTitleStepsByNumber(int stepNumber) {
        getDriver().clickElementByIndex(stepNumber - 1, titleSteps);
    }

}
