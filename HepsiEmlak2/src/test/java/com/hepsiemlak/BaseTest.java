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
import java.util.List;
import java.util.Random;

public class BaseTest {

    protected WebDriver driver;

    public static String loginUrl = "https://www.hepsiemlak.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options2 = new ChromeOptions();
        options2.addArguments("--disable-notifications");

        driver =new ChromeDriver(options2);
        driver.manage().window().maximize();
    }
    @Test
    public void correctLogin() throws InterruptedException {
        MainPage main2 = new MainPage(driver);
        SearchPage sehir = new SearchPage(driver);
        SearchPage min = new SearchPage(driver);



        driver.get(loginUrl);
        Thread.sleep(3000);
        main2.main();
        Thread.sleep(3000);
        sehir.sehir();
        JavascriptExecutor js = (JavascriptExecutor) driver;



        WebElement select = driver.findElement(By.cssSelector("div.ps.ps--active-y"));
        List<WebElement> options = select.findElements(By.cssSelector("li.he-select__list-item"));
        for (WebElement option : options) {
            if("Ankara".equals(option.getText()))
                option.click();
        }
        Thread.sleep(3000);
        WebElement a =driver.findElement(By.xpath("//*[@id=\"listPage\"]/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[6]/section/div/div[1]"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+a.getLocation().y+")");
        a.click();

        driver.findElement(By.xpath("//*[@id=\"listPage\"]/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[6]/section/div/div[2]/div/div/ul/li[3]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"listPage\"]/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[6]/section/div/div[1]")).click();

        WebElement b =driver.findElement(By.cssSelector("input.md-switch-input"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+b.getLocation().y+")");
        b.click();
        driver.findElement(By.cssSelector("a.btn.btn-red.btn-large")).click();
        Thread.sleep(3000);

     driver.findElement(By.xpath("//*[@id=\"91622-4514\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/button[1]")).click();




    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}