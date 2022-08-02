package pages;

import component.Locator;
import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.component.FilterFacet;
import pages.component.FilterFacetSearch;

public class NavigatorPage extends BasePage {

    public FilterFacetSearch topicFacetSection = new FilterFacetSearch(getLocatorByXpath("(//div[contains(@class,'FilterFacets__filterFacetsColumn')])[1]"));
    public FilterFacet experienceFacetSection = new FilterFacet(getLocatorByXpath("(//div[contains(@class,'FilterFacets__filterFacetsColumn')])[3]"));
    public Locator paginationNumberLink = getLocatorByXpath("//a[contains(@class,'PageLink__pageLink')]");

    public NavigatorPage(Locator locator) {
        super(locator);
    }

    public NavigatorPage() {
    }

    public int getPaginationSize() {
        int paginationSize = Driver.getDriver().findElements(paginationNumberLink).size();
        return paginationSize;
    }


    public void clickPaginationLinkByNumber(int pageNumber) {
        Driver.getDriver().clickPaginationByIndex(pageNumber, paginationNumberLink);
    }

}
