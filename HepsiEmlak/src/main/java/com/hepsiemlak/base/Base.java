package com.hepsiemlak.base;

import com.hepsiemlak.pages.MainPage;
import com.hepsiemlak.pages.SearchPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    private static final Logger log = LogManager.getLogger(Base.class);

    protected WebDriver driver;
    WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static void waitSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void clickElement(By by) {
        waitUntilPresence(by);
        WebElement element;
        element = findElement(by);
        if (!element.isDisplayed()) {
            scrollTo(element.getLocation().getX(), element.getLocation().getY());
        }
        try {
            waitUntilElementClickable(by);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            Assert.fail("Element tıklanabilir değil!");
        }
        element.click();
    }

    public void sendKeys(By by, String text) {
        waitUntilPresence(by);
        WebElement element;
        element = findElement(by);
        if (!element.isDisplayed()) {
            scrollTo(element.getLocation().getX(), element.getLocation().getY());
        }
        waitUntilElementClickable(by);
        element.sendKeys(text);
    }

    public void findTextAndClick(By by, String text) {
        log.info("Elementin var olması bekleniyor... ");
        waitUntilPresence(by);
        List<WebElement> searchText = driver.findElements(by);
        for (int i = 0; i < searchText.size(); i++) {
            if (searchText.get(i).getText().trim().contains(text)) {
                searchText.get(i).click();
                log.info("Bulunan elemente tıklandı.");
                break;
            }
        }
    }

    public void hoverElement(By by) {
        Actions action = new Actions(driver);
        log.info("Üstüne gelinen element :" + by);
        action.moveToElement(findElement(by)).build().perform();
    }


    protected void scrollTo(int x, int y) {
        String jsStmt = String.format("window.scrollTo(%d, %d);", x, y);
        getJSExecutor().executeScript(jsStmt, true);
    }

    public void selectVisibleText(By by, String text) {
        Select select = new Select(findElement(by));
        select.selectByVisibleText(text);
    }

    public String getText(By by) {
        waitUntilPresence(by);
        return findElement(by).getText();
    }

    public void assertionTrue(String message, boolean condition) {
        Assert.assertTrue(message, condition);
    }

    public void waitUntilPresence(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitUntilElementAppear(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementClickable(By by) {
        log.info("Elementin tıklanabilir olması bekleniyor.");
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void untilElementDissapear(By by) {
        WebDriverWait dissapear = new WebDriverWait(driver, 300);
        dissapear.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        dissapear.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void elementDisplayedControl(By by) {

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public MainPage callMainPage() {
        return new MainPage(driver);
    }

    public SearchPage callLoginPage() {
        return new SearchPage(driver);
    }


    }

