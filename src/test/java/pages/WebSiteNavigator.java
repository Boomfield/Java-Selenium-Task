package pages;

import configuration.ConfigProperties;
import data.PageUrls;
import data.CookieData;
import io.qameta.allure.Step;

import static driver.Driver.getDriver;

public class WebSiteNavigator {

    public void openDevelopersStartPage() {
        getDriver().navigate(ConfigProperties.developersUrl() + PageUrls.FAST_URL);
        getDriver().addCookies(CookieData.COOKIE1);
    }

    public void openNavigatorPageAndAcceptCookies(String url) {
        openDevelopersStartPage();
        getDriver().navigate(ConfigProperties.developersUrl() + url);

    }

    public void openSapStartPage() {
        getDriver().navigate(ConfigProperties.sapUrl() + PageUrls.FAST_URL);
        getDriver().addCookies(CookieData.COOKIE1);
        getDriver().addCookies(CookieData.COOKIE2);
    }

    @Step
    public void openSapPageAndAcceptCookies(String url) {
        openSapStartPage();
        getDriver().navigate(ConfigProperties.sapUrl() + url);
    }

}
