package tests;

import org.testng.annotations.*;
import pages.PageAndCookie;
import pages.tutorialNavigator.NavigatorPage;
import pages.tutorialNavigator.helpers.ExperienceType;
import steps.NavigatorSteps;

public class TestTutorialPage extends BaseTest {

    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private PageAndCookie navigationSap;

    public TestTutorialPage() {
        navigatorPage = new NavigatorPage();
        navigatorSteps = new NavigatorSteps();
        navigationSap = new PageAndCookie();
    }

    @DataProvider(name = "TopicSearchDataProvider", parallel = true)
    public Object[] getData() {
        Object[] data = {"android", "abap"};
        return data;
    }

    @Test(dataProvider = "TopicSearchDataProvider")
    public void checkResultSearchTopic(String searchFilterText) {
        navigationSap.openNavigatorPageAndAcceptCookies();
        navigatorPage.topicFacetSection.enterTopicSearchText(searchFilterText);
        navigatorSteps.VerifyAllTopicSearchResultsContains(searchFilterText);
    }

    @Test
    public void checkFilterExperienceWithTitleHeader() {
        navigationSap.openNavigatorPageAndAcceptCookies();
        navigatorPage.experienceFacetSection.clickExperienceFilter(ExperienceType.Intermediate);
        navigatorSteps.VerifyAllHeaderResultsContains(ExperienceType.Intermediate);
    }

}

