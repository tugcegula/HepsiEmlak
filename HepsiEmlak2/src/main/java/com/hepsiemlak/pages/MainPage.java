package com.hepsiemlak.pages;

import com.hepsiemlak.base.Base;
import org.openqa.selenium.WebDriver;
import static com.hepsiemlak.constants.ConstantMain.*;

public class MainPage extends Base{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage main(){

    clickElement(satilik);
    
    return new MainPage(driver);
    }
}
