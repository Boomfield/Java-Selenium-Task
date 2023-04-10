package pages.tutorialPage;

import component.Locator;
import pages.BasePage;
import pages.tutorialPage.component.TutorialStep;

import static driver.Driver.getDriver;

public class TutorialPage extends BasePage {
    public Locator navigationStep = getByXpath("//div[contains(@class,'TutorialSideBar__linkText')]");

    public TutorialStep getTutorialStep(int index) {
        return new TutorialStep(index);
    }

    public void clickStepTitleByNumber(int stepNumber) {
        getDriver().clickElementByIndex(stepNumber - 1, navigationStep);
    }
}
