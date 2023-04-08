package steps;

import pages.tutorialNavigator.NavigatorPage;
import pages.tutorialNavigator.TitlePage;
import pages.tutorialNavigator.component.ResultItem;
import pages.tutorialNavigator.helpers.ExperienceType;

import java.util.ArrayList;

import static driver.Driver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NavigatorSteps {

    private NavigatorPage navigatorPage = new NavigatorPage();
    private TitlePage titlePage = new TitlePage();
    public ResultItem resultItem = new ResultItem();

    public void verifyAllTopicSearchResultsContains(String text) {
        ArrayList<String> list = navigatorPage.topicFacetSection.getTopicSearchResults();
        assertThat(list, everyItem(containsStringIgnoringCase(text)));
    }

    public void verifyAllHeaderResultsContains(ExperienceType nameFilter) {
        for (int i = 0; i < navigatorPage.getPaginationSize(); i++) {
            navigatorPage.clickPaginationLinkByNumber(i);
            ArrayList<String> allHeaderTitle = getDriver().getElementsText(resultItem.headerTitle);
            assertThat(allHeaderTitle, everyItem(equalTo(nameFilter.toString())));
        }
    }

    public void verifyAllBodyResultsContains(String name) {
        for (int i = 0; i < navigatorPage.getPaginationSize(); i++) {
            navigatorPage.clickPaginationLinkByNumber(i);
            ArrayList<String> allBodyLabel = getDriver().getElementsText(resultItem.bodyLabel);
            assertThat(allBodyLabel, everyItem(equalTo(name)));
        }
    }

    public void verifyStepTutorialNumber(int stepNumber) {
        assertThat(getDriver().isVisibleInViewport(titlePage.getStepTutorials(stepNumber).stepHeadTitle), is(true));
    }

    public void verifyStepTutorialIsOpen(int stepNumber) {
        assertThat(titlePage.getStepTutorials(stepNumber).isStepExpanded(), is(true));
    }

}
