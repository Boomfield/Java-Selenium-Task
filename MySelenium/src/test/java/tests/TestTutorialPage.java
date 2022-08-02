package tests;

import data.PageUrls;
import org.testng.annotations.*;
import pages.NavigationSap;
import pages.NavigatorPage;
import pages.helpers.ExperienceType;
import steps.NavigatorSteps;

public class TestTutorialPage extends BaseTest {

    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private NavigationSap navigationSap;

    public TestTutorialPage() {
        navigatorPage = new NavigatorPage();
        navigatorSteps = new NavigatorSteps();
        navigationSap = new NavigationSap();
    }

    @DataProvider(name = "TopicSearchDataProvider", parallel = true)
    public Object[] getData() {
        Object[] data = {"android", "abap"};
        return data;
    }

    @Test(dataProvider = "TopicSearchDataProvider")
    public void checkResultSearchTopic(String searchFilterText) {
        navigationSap.openPageAndAcceptCookies(PageUrls.tutorials);
        navigatorPage.topicFacetSection.enterTopicSearchText(searchFilterText);
        navigatorSteps.VerifyAllTopicSearchResultsContains(searchFilterText);
    }

    @Test
    public void checkFilterExperienceWithTitleHeader() {
        navigationSap.openPageAndAcceptCookies(PageUrls.tutorials);
        navigatorPage.experienceFacetSection.clickExperienceFilter(ExperienceType.Intermediate);
        navigatorSteps.VerifyAllHeaderResultsContains(ExperienceType.Intermediate);
    }

}

