package tests;

import data.PageUrls;
import org.testng.annotations.*;
import pages.WebSiteNavigator;
import pages.tutorialNavigator.NavigatorPage;
import pages.tutorialNavigator.TitlePage;
import pages.tutorialNavigator.data.TutorialNavigatorData;
import pages.tutorialNavigator.helpers.ExperienceType;
import pages.tutorialNavigator.helpers.OptionType;
import steps.NavigatorSteps;

public class TutorialNavigatorTests extends BaseTest {

    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private TitlePage titlePage;
    private WebSiteNavigator navigationSap;

    public TutorialNavigatorTests() {
        navigatorPage = new NavigatorPage();
        navigatorSteps = new NavigatorSteps();
        titlePage = new TitlePage();
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

        navigatorSteps.verifyAllTopicSearchResultsContains(searchFilterText);
    }

    @Test
    public void checkFilterExperienceWithTitleHeader() {
        navigationSap.openNavigatorPageAndAcceptCookies(PageUrls.TUTORIALS);

        navigatorPage.experienceFacetSection.clickExperienceFilter(ExperienceType.INTERMEDIATE);

        navigatorSteps.verifyAllHeaderResultsContains(ExperienceType.INTERMEDIATE);

    }

    @Test
    public void checkFilterOptionWithTitleHeader() {
        navigationSap.openNavigatorPageAndAcceptCookies(PageUrls.TUTORIALS);

        navigatorPage.optionFacetSection.clickOptionFilter(OptionType.NEW_TUTORIALS);

        navigatorSteps.verifyAllBodyResultsContains(TutorialNavigatorData.NEW_LABEL_TEXT);
    }

    @Test()
    public void checkTitlePageOnSteps() {
        int stepNumber = 3;
        navigationSap.openNavigatorPageAndAcceptCookies(PageUrls.STEP_TUTORIALS);

        titlePage.stepTutorials.waitLoadStepAndClose(1);

        titlePage.clickTitleStepsByNumber(stepNumber);

        navigatorSteps.verifyStepTutorialNumber(stepNumber);

        navigatorSteps.verifyStepTutorialIsOpen(stepNumber);
    }

}



