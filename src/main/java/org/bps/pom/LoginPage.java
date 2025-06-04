package org.bps.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

import static com.google.common.truth.Truth.assertThat;

public class LoginPage extends BasePage{
    WebDriver driver;
    By landingPageLoginLink = By.id("login_Layer");
    By loginForm = By.cssSelector("form[name=\"login-form\"]");
    By unameField = By.cssSelector("input[placeholder*=\"Email ID\"]");
    By passwordField = By.cssSelector("input[placeholder*=\"password\"]");
    By loginButton = By.cssSelector("button.loginButton");
    By applicantNameField = By.cssSelector("div.info__heading");
    By rightDrawerProfileImageLink = By.cssSelector("div div img[alt*=\"user profile img\"]");
    By logoutButton = By.cssSelector("a[title=\"Logout\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickOnLandingPageLoginButton(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(landingPageLoginLink).click();
        return this;
    }

    public LoginPage verifyLoginForm(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertThat(driver.findElement(loginForm).isDisplayed()).isTrue();
        return this;
    }

    public LoginPage enterLoginCred(String uname, String pass){
        driver.findElement(unameField).sendKeys(uname);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginPage verifyLoginIsSuccessful(String applicantName){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertThat(driver.findElement(applicantNameField).getText()).isEqualTo(applicantName);
        return  this;
    }

    public LoginPage performLogout(){
        driver.findElement(rightDrawerProfileImageLink).click();
        driver.findElement(logoutButton).click();
        assertThat(driver.findElement(landingPageLoginLink).isDisplayed()).isTrue();
        return this;
    }

}
