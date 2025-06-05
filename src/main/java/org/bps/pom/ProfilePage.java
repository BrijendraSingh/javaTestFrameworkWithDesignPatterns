package org.bps.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ProfilePage extends BasePage{

    By viewProfileButton = By.cssSelector("div.view-profile-wrapper a");
    By updateResumeLink = By.xpath("//li/a[text()='Update']");
    By fileInputLocator = By.cssSelector("input#attachCV");
    By resumeUploadSuccessMsg = By.xpath("//p[text()='Resume has been successfully uploaded.']");

    public ProfilePage(WebDriver driver, int timeoutInSeconds) {
        super(driver, timeoutInSeconds);
    }

    public ProfilePage clickOnViewProfileButton(){
        click(viewProfileButton);
        return this;
    }

    public ProfilePage clickOnUpdateResumeLink(){
        isDisplayed(updateResumeLink);
//        click(updateResumeLink);
        return this;
    }

    public ProfilePage uploadResume(){
        String filePath = new File("src/test/resources/testdata/BrijendraSingh_PrincipalQA_Resume.pdf").getAbsolutePath();
        uploadFile(fileInputLocator, filePath);
        isDisplayed(resumeUploadSuccessMsg);
        return this;
    }

}
