package pages.tutorialNavigator.component;

import component.Locator;
import pages.BasePage;

public class ResultItem extends BasePage {
    public Locator headerTitle = getByXpath("//div[contains(@class,'Header__experience')]");
}
