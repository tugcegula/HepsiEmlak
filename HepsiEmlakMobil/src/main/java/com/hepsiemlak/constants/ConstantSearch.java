package com.hepsiemlak.constants;

import org.openqa.selenium.By;

public class ConstantSearch {
    public static final By filtrele = By.xpath("//button[@class='btn btn-white']//span[@class='val']");
    public static final By sehir = By.cssSelector("div.city");
    public static final By ankara = By.xpath("//option[@value='ankara']");
    public static final By sec = By.cssSelector("div.custom-select");
    public static final By ilce = By.xpath("//div[@class='district-list-dialog']//li[7]");
    public static final By ilceSec = By.xpath("//div[@class='wrapper']/section[1]/section[1]/div[2]/div[2]/button");
    public static final By odaSec= By.xpath("//section[@class='room-type']/section/div");
    public static final By odaSayisi= By.xpath("//ul[@class='list']//li[3]/label");
    public static final By odaKapat = By.xpath("//div[@class='wrapper']/section[4]/section[1]/div[2]/div[2]/button");
    public static final By siteIci= By.xpath("//section[@class='within-site d-flex']/label");
    public static final By filtreKapat= By.cssSelector("span.he-svg.he-svg--close");
    public static final By ucuncu= By.xpath("//div[@class='reality-list']/div[3]/div[2]/div[2]/div/a");




}
