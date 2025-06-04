package org.bps.testFlows;

import org.openqa.selenium.WebDriver;

public class JobApplicantFlow  extends  BaseFlow{
    NaukriLoginFlow loginFlow;
    UpdateProfileFlow profileFlow;

    public JobApplicantFlow(WebDriver driver){
        this.loginFlow = new NaukriLoginFlow(driver);
    }

    public JobApplicantFlow performLogin(){
        loginFlow
                .performLoginToNaukriPortal();
        return this;
    }

    public JobApplicantFlow performLoginAndLogout(){
        loginFlow
                .performLoginToNaukriPortal()
                .performLogout();
        return this;
    }

    public JobApplicantFlow switchToProfileFlow(){
        profileFlow = loginFlow.switchToProfileFlow();
        return this;
    }

    public JobApplicantFlow updateResume(){
       if(profileFlow ==null){
           throw new RuntimeException("Profile flow is not switch properly");
       } else {
           profileFlow
                   .navigateToProfileSection()
                   .updateResume();
       }
        return this;
    }

    public JobApplicantFlow performLogout(){
        loginFlow.performLogout();
        return this;
    }
}
