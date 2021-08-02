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

public class BaseTest {

    protected WebDriver driver;

    public static String loginUrl = "https://www.hepsiemlak.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //Create a instance of ChromeOptions class
        ChromeOptions options2 = new ChromeOptions();

//Add chrome switch to disable notification - "**--disable-notifications**"
        options2.addArguments("--disable-notifications");
//Pass ChromeOptions instance to ChromeDriver Constructor
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
            if("İzmir".equals(option.getText()))
                option.click();
        }
        WebElement a =driver.findElement(By.cssSelector("input.floating-input.priceMin"));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+a.getLocation().y+")");
        a.click();
        driver.findElement(By.cssSelector("input.floating-input.priceMin")).sendKeys("100000");
        driver.findElement(By.cssSelector("input.floating-input.priceMax")).sendKeys("2000000");
        Thread.sleep(3000);
        WebElement bina =driver.findElement(By.cssSelector("section.buildingAgeSec"));
        bina.click();


        driver.findElement(By.xpath("//*[@id=\"listPage\"]/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[7]/section/div/div[2]/div/div/ul/li[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"listPage\"]/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[7]/section/div/div[2]/div/div/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"listPage\"]/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[7]/section/div/div[2]/div/div/ul/li[3]/label")).click();
        //driver.findElement(By.cssSelector("section.listing-filter")).click();
        driver.findElement(By.cssSelector("a.btn.btn-red.btn-large")).click();
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.cssSelector("span.applied-filters-list-item last--item"));
        System.out.println(list);
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector("#main-category1")).click();




    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}