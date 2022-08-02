package pages.component;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.helpers.ExperienceType;
import wait.Waiter;

import java.util.ArrayList;

import static driver.Driver.getDriver;

public class FilterFacet extends BasePage {

    public Locator resultLabelBy = getLocatorByCss("div.simplebar-content span");
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
