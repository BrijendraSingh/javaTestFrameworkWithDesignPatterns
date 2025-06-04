package org.bps.browser;

import org.openqa.selenium.WebDriver;

public class ResolveBrowser {
    public WebDriver driver;
    public WebDriver resolve(String browser) {
        driver = switch (browser) {
            case "chrome"->
                new BrowserFactory().getDriver(new ChromeDriverManager());
            case "safari"->
                new BrowserFactory().getDriver(new SafariDriverManager());
            default->
                throw new IllegalStateException("Unexpected value: " + browser);
        };
        return driver;
    }
}
