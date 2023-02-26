package tests;

import data.PageUrls;
import org.testng.annotations.*;
import pages.WebSiteNavigator;
import pages.tutorialNavigator.NavigatorPage;
import pages.tutorialNavigator.data.TutorialNavigatorData;
import pages.tutorialNavigator.helpers.ExperienceType;
import pages.tutorialNavigator.helpers.OptionType;
import settings.RetryAnalyzer;
import steps.NavigatorSteps;

public class TutorialNavigatorTests extends BaseTest {

    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private WebSiteNavigator navigationSap;

    public TutorialNavigatorTests() {
        navigatorPage = new NavigatorPage();
        navigatorSteps = new NavigatorSteps();
        navigationSap = new WebSiteNavigator();
    }

    @DataProvider(name = "TopicSearchDataProvider", parallel = true)
    public Object[] getData() {
        Object[] data = {"android", "abap"};
        return data;
    }

    @Test(dataProvider = "TopicSearchDataProvider")
    public void checkResultSearchTopic(String searchFilterText) {
        navigationSap.openNavigatorPageAndAcceptCookies(PageUrls.TUTORIALS);
        navigatorPage.topicFacetSection.enterTopicSearchText(searchFilterText);
        navigatorSteps.VerifyAllTopicSearchResultsContains(searchFilterText);
    }

    @Test
    public void checkFilterExperienceWithTitleHeader() {
        navigationSap.openNavigatorPageAndAcceptCookies(PageUrls.TUTORIALS);
        navigatorPage.experienceFacetSection.clickExperienceFilter(ExperienceType.Intermediate);
        navigatorSteps.VerifyAllHeaderResultsContains(ExperienceType.Intermediate);
    }

    @Test
    public void checkFilterOptionWithTitleHeader() {
        navigationSap.openNavigatorPageAndAcceptCookies(PageUrls.TUTORIALS);
        navigatorPage.optionFacetSection.clickOptionFilter(OptionType.NewTutorials);
        navigatorSteps.VerifyAllBodyResultsContains(TutorialNavigatorData.NEW_LABEL_TEXT);
    }

}

