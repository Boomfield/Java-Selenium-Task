package pages.tutorialNavigator;

import component.Locator;
import pages.BasePage;
import pages.tutorialNavigator.component.FilterFacet;
import pages.tutorialNavigator.component.FilterFacetSearch;

import static driver.Driver.getDriver;

public class NavigatorPage extends BasePage {

    public FilterFacetSearch topicFacetSection = new FilterFacetSearch(getByXpath("(//div[contains(@class,'FilterFacets__filterFacetsColumn')])[1]"));
    public FilterFacet experienceFacetSection = new FilterFacet(getByXpath("(//div[contains(@class,'FilterFacets__filterFacetsColumn')])[3]"));
    public FilterFacet optionFacetSection = new FilterFacet(getByXpath("(//div[contains(@class,'FilterFacets__filterFacetsColumn')])[5]"));
    public Locator paginationNumberLink = getByXpath("//a[contains(@class,'PageLink__pageLink')]");

    public NavigatorPage(Locator locator) {
        super(locator);
    }

    public NavigatorPage() {
    }

    public int getPaginationSize() {
        int paginationSize = getDriver().findElements(paginationNumberLink).size();
        return paginationSize;
    }

    public void clickPaginationLinkByNumber(int pageNumber) {
        getDriver().clickElementByIndex(pageNumber, paginationNumberLink);
    }

}
