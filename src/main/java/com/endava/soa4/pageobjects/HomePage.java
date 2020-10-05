package com.endava.soa4.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driverManager;

    public HomePage(WebDriver driverManager) {
        this.driverManager = driverManager;
        PageFactory.initElements(driverManager, this);
    }

    @Getter
    @FindBy(css = ".menu-content>li")
    private List<WebElement> heading;

    @Getter
    String url = "http://automationpractice.com/index.php";

}
