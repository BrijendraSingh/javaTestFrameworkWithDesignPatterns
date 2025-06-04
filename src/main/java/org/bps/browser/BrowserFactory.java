package org.bps.browser;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    BrowserManager browserManager;

    public WebDriver getDriver(BrowserManager browserManager){
       return browserManager.getDriver();
    }
}
