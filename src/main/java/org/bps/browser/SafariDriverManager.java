package org.bps.browser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager implements BrowserManager{
    @Override
    public WebDriver getDriver() {
        System.out.println("Safari driver is initialized");
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new SafariDriver(safariOptions);
    }
}
