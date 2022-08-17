package pages.tutorialNavigator.component;

import component.Locator;
import driver.Driver;
import pages.BasePage;
import pages.tutorialNavigator.helpers.ExperienceType;
import wait.Waiter;


import static driver.Driver.getDriver;

public class FilterFacet extends BasePage {

    public Locator resultLabelBy = getByCss("div.simplebar-content span");
    public ResultItem resultItem = new ResultItem();

    public FilterFacet(Locator locator) {
        super(locator);
    }

    public FilterFacet() {
    }

    public void clickExperienceFilter(ExperienceType nameFilterExperience) {
        Waiter.wait(() -> Driver.getDriver().exist(resultItem.headerTitle), 10);
        getDriver().clickByText(resultLabelBy, nameFilterExperience.toString());
    }

}
