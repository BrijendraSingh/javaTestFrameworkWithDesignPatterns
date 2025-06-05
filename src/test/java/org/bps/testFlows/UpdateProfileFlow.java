package org.bps.testFlows;

import org.bps.pom.ProfilePage;
import org.openqa.selenium.WebDriver;

public class UpdateProfileFlow extends BaseFlow{
    ProfilePage profilePage;
    public UpdateProfileFlow(WebDriver driver){
        this.profilePage = new ProfilePage(driver,10);
    }

    public UpdateProfileFlow navigateToProfileSection(){
        System.out.println("Navigate to profile section");
        profilePage.clickOnViewProfileButton();
        return  this;
    }

    public UpdateProfileFlow updateResume(){
        System.out.println("Update resume step");
        profilePage
                .clickOnUpdateResumeLink()
                .uploadResume();
        return this;
    }
}
