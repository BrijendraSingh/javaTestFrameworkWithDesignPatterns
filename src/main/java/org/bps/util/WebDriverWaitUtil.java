package org.bps.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebDriverWaitUtil {
    private final WebDriverWait wait;
    WebDriver driver;
    public WebDriverWaitUtil(WebDriver driver, int timeoutInSeconds){
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        this.driver = driver;
    }

    public WebElement $(By locator){
//        return wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    public List<WebElement> $$(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeys(By locator, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    public String getText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void uploadFile(By locator, String filePath){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(filePath);
        $(locator).sendKeys(filePath);
    }

    public boolean isDisplayed(By locator){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e){
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    public WebElement waitForCondition(By locator, String condition) {
        switch (condition.toLowerCase()) {
            case "clickable":
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            case "present":
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            case "visible":
            default:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
    }

}
