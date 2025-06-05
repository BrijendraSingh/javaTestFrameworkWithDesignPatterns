package org.bps.pom;

import org.bps.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

import static com.google.common.truth.Truth.assertThat;

public class LoginPage extends BasePage{
    By landingPageLoginLink = By.id("login_Layer");
    By loginForm = By.cssSelector("form[name=\"login-form\"]");
    By unameField = By.cssSelector("input[placeholder*=\"Email ID\"]");
    By passwordField = By.cssSelector("input[placeholder*=\"password\"]");
    By loginButton = By.cssSelector("button.loginButton");
    By applicantNameField = By.cssSelector("div.info__heading");
    By rightDrawerProfileImageLink = By.cssSelector("div div img[alt*=\"user profile img\"]");
    By logoutButton = By.cssSelector("a[title=\"Logout\"]");

    public LoginPage(WebDriver driver){
        super(driver,10);
    }

    public LoginPage clickOnLandingPageLoginButton(){
        click(landingPageLoginLink);
        return this;
    }

    public LoginPage verifyLoginForm(){
        assertThat(isDisplayed(loginForm)).isTrue();
        return this;
    }

    public LoginPage enterLoginCred(String uname, String pass){
        sendKeys(unameField, uname);
        sendKeys(passwordField,pass);
        click(loginButton);
        return this;
    }

    public LoginPage verifyLoginIsSuccessful(String applicantName){
        assertThat(getText(applicantNameField)).isEqualTo(applicantName);
        return  this;
    }

    public LoginPage performLogout(){
        click(rightDrawerProfileImageLink);
        click(logoutButton);
        assertThat(isDisplayed(landingPageLoginLink)).isTrue();
        return this;
    }
}
