package pages.tutorialNavigator.component;

import component.Locator;
import driver.Driver;

import java.util.ArrayList;

public class FilterFacetSearch extends FilterFacet {

    public Locator filterSearchBy = getByXpath(".//input[contains(@class,'SearchInput__input')]");

    public FilterFacetSearch(Locator locator) {
        super(locator);
    }

    public void enterTopicSearchText(String title) {
        Driver.getDriver().enterText(filterSearchBy, title);
    }

    public ArrayList<String> getTopicSearchResults() {
        return Driver.getDriver().getElementsText(resultLabelBy);
    }

}
