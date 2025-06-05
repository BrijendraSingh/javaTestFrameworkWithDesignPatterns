package org.bps.hooks;

import org.bps.config.ConfigLoader;
import org.bps.config.TestEnvironment;
import org.openqa.selenium.WebDriver;
import org.bps.browser.ResolveBrowser;
import org.bps.testFlows.JobApplicantFlow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    public JobApplicantFlow jobApplicant;
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void testSetup(String browser){
        TestEnvironment.set();
        if(browser!=null) {
            driver = new ResolveBrowser().resolve(browser);
        } else{
            driver = new ResolveBrowser().resolve(ConfigLoader.getBrowser());
        }
        this.jobApplicant = new JobApplicantFlow(driver);
        System.out.println("Test Setup");
    }

    @AfterMethod
    public void testTearDown(){
        System.out.println("Test Tear down");
        driver.close();
    }
}
