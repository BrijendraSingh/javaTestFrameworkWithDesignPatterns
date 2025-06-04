package org.bps.browser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements BrowserManager{
    @Override
    public WebDriver getDriver() {
        System.out.println("Chrome driver is initialized");
        ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new ChromeDriver(options);
    }
}
