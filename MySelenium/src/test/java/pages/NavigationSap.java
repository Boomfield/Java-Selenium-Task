package pages;

import configuration.SiteProperties;
import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import pages.component.CookieComponent;

import static driver.Driver.getDriver;

public class NavigationSap extends BasePage {

    public CookieComponent cookieComponent = new CookieComponent();

    public void openPageAndAcceptCookies(String tutorials) {
        getDriver().navigate(SiteProperties.URLSAPDEVELOPER + tutorials);
        cookieComponent.closeCookie();
    }

    @Step
    public void openSapPageAndAcceptCookies() {
        removeCookie();
        getDriver().navigate(SiteProperties.URLSAP);

    }

    public void removeCookie() {
        getDriver().navigate(SiteProperties.FASTURL);
        Cookie cookie1 = new Cookie("notice_gdpr_prefs", "0,1,2:");
        Cookie cookie2 = new Cookie("notice_preferences", "2:");
        getDriver().driver.manage().addCookie(cookie1);
        getDriver().driver.manage().addCookie(cookie2);
    }

}
