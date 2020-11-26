package com.ebuyer.pages;

import com.ebuyer.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ebuyer.base.DriverContext.driver;

public class SearchPage extends Base {

    private By productSearchBox = By.id("search-box");
    private By productSearchButton = By.id("search-button");
    private static By quickFindText = By.xpath("//*[@id=\"main-content\"]/div/div[2]/div[1]/div[1]/span[1]");

    public SearchPage enterProductSearchBox ( String product ) {
        driver.findElement(productSearchBox).sendKeys(product);
        return this;
    }

    public SearchPage clickProductSearchButton () {
        driver.findElement(productSearchButton).click();
        return this;
    }

    public String getQuickFindText (){
        new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(quickFindText));
        WebElement quickFind = driver.findElement(quickFindText);
        return quickFind.getText();
    }
}