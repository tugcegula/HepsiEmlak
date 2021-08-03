package com.hepsiemlak;

import com.hepsiemlak.pages.MainPage;

import com.hepsiemlak.pages.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


public class BaseTest {

    protected WebDriver driver;

    public static String loginUrl = "https://www.hepsiemlak.com/";
    private Object TimeUnit;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 6");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void correctLogin() throws InterruptedException {
        MainPage main2 = new MainPage(driver);
        SearchPage secim = new SearchPage(driver);
        SearchPage odaKapat = new SearchPage(driver);
        SearchPage filtre = new SearchPage(driver);


        driver.get(loginUrl);
        //cerezleri kapat ve kiralıga bas
        main2.main();
        //filtrelemeye tıkla
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("//button[@class='btn btn-white']//span[@class='val']")))).click();
        //sehir ve ilce sec
        secim.secim();
        //oda
        WebElement oda = driver.findElement(By.xpath("//section[@class='room-type']/section/div"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+oda.getLocation().y+")");
        oda.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("//ul[@class='list']//li[3]/label")))).click();
        odaKapat.odaKapat();

        //site iiç secimi

        WebElement site =driver.findElement(By.xpath("//section[@class='within-site d-flex']/label"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+site.getLocation().y+")");
        site.click();

        //filtrelemeyi kapat
        filtre.filtreKapat();
        WebElement sec =driver.findElement(By.xpath("//div[@class='reality-list']/div[3]/div[2]/div[2]/div/a"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+sec.getLocation().y+")");
        sec.click();



    }


    @After
    public void tearDown() {

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
       driver.close();
       driver.quit();
    }
}