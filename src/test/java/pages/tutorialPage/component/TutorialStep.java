package pages.tutorialPage.component;

import component.Locator;
import pages.BasePage;
import wait.Waiter;

import static driver.Driver.getDriver;

public class TutorialStep extends BasePage {

    public Locator titleLabel = getByXpath(".//*[contains(@class,'Header__url')]");
    public Locator bodySection = getByXpath(".//div[contains(@class,'Expander__wrapper')]");

    public TutorialStep(int index) {
        super(Locator.xpath("//div[contains(@class,'Expander__expander')]", index));
    }

    public void waitLoadStep() {
        Waiter.wait(() -> isStepExpanded(), 5);
    }

    public boolean isStepExpanded() {
        int height = Integer.parseInt(getDriver().getAttribute(bodySection, "offsetHeight"));
        return height != 0;
    }
}
