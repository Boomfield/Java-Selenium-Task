package pages.component;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class FilterFacetSearch extends FilterFacet {

    public Locator filterSearchBy = getLocatorByXpath(".//input[contains(@class,'SearchInput__input')]");

    public FilterFacetSearch(Locator locator) {
        super(locator);
    }

    public void enterTopicSearchText(String title) {
        Driver.getDriver().enterText(filterSearchBy, title);
    }

    public ArrayList<String> getTopicSearchResults() {
        return Driver.getDriver().getResultTextList(resultLabelBy);
    }

}
