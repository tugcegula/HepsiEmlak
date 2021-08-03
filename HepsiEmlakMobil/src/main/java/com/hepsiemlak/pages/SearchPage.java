package com.hepsiemlak.pages;

import com.hepsiemlak.base.Base;
import org.openqa.selenium.WebDriver;

import static com.hepsiemlak.constants.ConstantSearch.*;


public class SearchPage extends Base {
    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public SearchPage filtrele(){

        clickElement(filtrele);

        return new SearchPage(driver);
    }

    public SearchPage secim(){

        clickElement(sehir);
        clickElement(ankara);
        clickElement(sec);
        clickElement(ilce);
        clickElement(ilceSec);

        return new SearchPage(driver);
    }

    public SearchPage odaKapat(){


        clickElement(odaKapat);
        return new SearchPage(driver);
    }


    public SearchPage siteIci(){

        clickElement(siteIci);

        return new SearchPage(driver);
    }

    public SearchPage filtreKapat(){

        clickElement(filtreKapat);

        return new SearchPage(driver);
    }
    public SearchPage ucuncu(){

        clickElement(ucuncu);

        return new SearchPage(driver);
    }

    public Object odaSec() {
        odaSec();
        return new SearchPage(driver);
    }
}
