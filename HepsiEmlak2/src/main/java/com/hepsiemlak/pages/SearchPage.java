package com.hepsiemlak.pages;

import com.hepsiemlak.base.Base;
import org.openqa.selenium.WebDriver;

import static com.hepsiemlak.constants.ConstantSearch.*;


public class SearchPage extends Base {
    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public SearchPage sehir(){

        clickElement(sehir);

        return new SearchPage(driver);
    }

    public SearchPage ilce(){

        clickElement(ilce);

        return new SearchPage(driver);
    }



    public SearchPage min(){

        min();

        return new SearchPage(driver);
    }

    public SearchPage max(){

        clickElement(max);

        return new SearchPage(driver);
    }

    public SearchPage bina(){

        clickElement(bina);

        return new SearchPage(driver);
    }

    public SearchPage search(){

        clickElement(search);

        return new SearchPage(driver);
    }


}
