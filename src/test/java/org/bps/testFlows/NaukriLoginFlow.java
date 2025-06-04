package org.bps.testFlows;

import org.bps.pom.LoginPage;
import org.openqa.selenium.WebDriver;

public class NaukriLoginFlow extends BaseFlow{
    WebDriver driver;
    LoginPage loginPage;
    public NaukriLoginFlow(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public NaukriLoginFlow performLoginToNaukriPortal(){
        System.out.println("naukri login step");
        driver.navigate().to("https://www.naukri.com");
        loginPage
                .clickOnLandingPageLoginButton()
                .verifyLoginForm()
                .enterLoginCred("bps.brijendra@gmail.com","Brij@9926744606")
                .verifyLoginIsSuccessful("Brijendra Singh");
        return  this;
    }

    public UpdateProfileFlow switchToProfileFlow(){
        System.out.println("switch context to updateProfileFlow from loginFlow");
        return  new UpdateProfileFlow(driver);
    }

    public NaukriLoginFlow performLogout(){
        loginPage.performLogout();
        return this;
    }
}
