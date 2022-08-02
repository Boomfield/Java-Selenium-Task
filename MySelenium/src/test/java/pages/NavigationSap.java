package pages;

import configuration.SiteProperties;
import driver.Driver;
import io.qameta.allure.Step;
import pages.component.CookieComponent;

public class NavigationSap extends BasePage {

    public CookieComponent cookieComponent = new CookieComponent();

    public void openPageAndAcceptCookies(String tutorials) {
        Driver.getDriver().navigate(SiteProperties.URLSAPDEVELOPER + tutorials);
        cookieComponent.closeCookie();
    }

    @Step
    public void openSapPageAndAcceptCookies() {
        Driver.getDriver().navigate(SiteProperties.URLSAP);
        cookieComponent.closeCookie();
    }

}
