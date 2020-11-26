package com.ebuyer.pages;

import com.ebuyer.base.Base;
import com.ebuyer.config.Settings;
import org.openqa.selenium.By;

import java.io.IOException;
import static com.ebuyer.base.DriverContext.driver;

public class HomePage extends Base {
    private By acceptAllCookiesButton = By.xpath("/html/body/div[3]/div/button[2]");

    public HomePage visit () throws IOException {
        driver.manage().window().maximize();
        driver.get(Settings.siteUrl);
        return this;
    }

    public HomePage acceptCookiePreferences() {
        driver.findElement(acceptAllCookiesButton).click();
        return this;
    }
}