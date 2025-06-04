package org.bps.testFlows;

import org.openqa.selenium.WebDriver;

public class UpdateProfileFlow extends BaseFlow{
    WebDriver driver;
    public UpdateProfileFlow(WebDriver driver){
        this.driver = driver;
    }

    public UpdateProfileFlow navigateToProfileSection(){
        System.out.println("Navigate to profile section");
        return  this;
    }

    public UpdateProfileFlow updateResume(){
        System.out.println("Update resume step");
        return this;
    }
}
