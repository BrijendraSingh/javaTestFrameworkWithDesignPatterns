package org.bps.pom;
import org.bps.util.WebDriverWaitUtil;
import org.openqa.selenium.WebDriver;

import static com.google.common.truth.Truth.assertThat;

public class BasePage extends WebDriverWaitUtil {
    public BasePage(WebDriver driver, int timeoutInSeconds) {
        super(driver, timeoutInSeconds);
    }
}
