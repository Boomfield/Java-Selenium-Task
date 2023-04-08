package pages.tutorialNavigator.component;

import component.Locator;
import pages.BasePage;
import wait.Waiter;

import static driver.Driver.getDriver;

public class StepTutorials extends BasePage {

    public Locator stepNumber = getByXpath(".//*[contains(@class,'Top__title')]");
    public Locator stepHeadTitle = getByXpath(".//*[contains(@class,'Header__url')]");
    public Locator buttonCloseAll = getByXpath("(//button[contains(@class,'Options__button')])[2]");
    public Locator buttonDone = getByXpath(".//button[contains(@class,'SubmitButton__button')]");
    public Locator stepExpander = getByXpath(".//div[contains(@class,'Expander__wrapper')]");

    public StepTutorials(int index) {
        super(Locator.getXpathWithIndex("//div[contains(@class,'Expander__expander')]", index));
    }

    public StepTutorials() {
    }

    public void waitLoadStepAndClose(int number) {
        Waiter.wait(() -> getDriver().dispayed(Locator.getXpathWithIndex(stepNumber.toString(), number)), 2);
        getDriver().click(buttonCloseAll);
    }

    public boolean checkAttributeHeight(Locator locator, String name) {
        int height = Integer.parseInt(getDriver().getAttribute(locator, name));
        return height != 0;
    }
}
