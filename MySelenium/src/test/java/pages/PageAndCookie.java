package pages;

import configuration.ConfigProperties;
import data.PageUrls;
import io.qameta.allure.Step;

import static driver.Driver.getDriver;

public class PageAndCookie {

    public void acceptCookieNavigatorPage() {
        getDriver().navigate(ConfigProperties.DEVELOPERS_URL + PageUrls.FAST_URL);
        getDriver().addCookies();
    }

    public void openNavigatorPageAndAcceptCookies() {
        acceptCookieNavigatorPage();
        getDriver().navigate(ConfigProperties.DEVELOPERS_URL + PageUrls.TUTORIALS);

    }

    public void acceptCookieSapPage() {
        getDriver().navigate(ConfigProperties.SAP_URL + PageUrls.FAST_URL);
        getDriver().addCookies();
    }

    @Step
    public void openSapPageAndAcceptCookies() {
        acceptCookieSapPage();
        getDriver().navigate(ConfigProperties.SAP_URL);

    }

}
