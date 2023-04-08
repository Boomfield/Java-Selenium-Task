package pages.tutorialNavigator.component;

import component.Locator;
import pages.BasePage;
import wait.Waiter;

import static driver.Driver.getDriver;

public class StepTutorials extends BasePage {

    public Locator stepHeadTitle = getByXpath(".//*[contains(@class,'Header__url')]");
    public Locator stepBlock = getByXpath(".//div[contains(@class,'Expander__wrapper')]");

    public StepTutorials(int index) {
        super(Locator.xpath("//div[contains(@class,'Expander__expander')]", index));
    }

    public StepTutorials() {
    }

    public void waitLoadStep() {
        Waiter.wait(() -> isStepExpanded(), 5);
    }

    public boolean isStepExpanded() {
        int height = Integer.parseInt(getDriver().getAttribute(stepBlock, "offsetHeight"));
        return height != 0;
    }
}
