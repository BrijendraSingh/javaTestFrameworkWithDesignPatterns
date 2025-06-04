package org.bps.testScripts;

import org.bps.hooks.BaseTest;
import org.testng.annotations.Test;

public class NaukriLoginTest extends BaseTest {

    @Test
    public void naukriLoginTest(){
        jobApplicant
                .performLoginAndLogout()
                .end();
    }

    @Test
    public void updateResumeTest(){
       jobApplicant
               .performLogin()
               .switchToProfileFlow()
               .updateResume()
               .performLogout()
               .end();
    }
}
