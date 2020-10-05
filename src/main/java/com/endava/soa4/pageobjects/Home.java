package com.endava.soa4.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Home extends Page {
    @FindBy(className = "login")
    private WebElement signInButton;
    @FindBy(tagName = "title")
    private WebElement title;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]")
    private WebElement firstItemImg;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a")
    private WebElement firstItemDescription;
    @FindBy(className = "homefeatured")
    private WebElement popularItemscategory;

    public Home(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignIn() {
        driverWait.until(visibilityOf(signInButton));
        signInButton.click();
    }
    public String getPopularItemscategory() {
        driverWait.until(visibilityOf(popularItemscategory));
        System.out.println(title.getText());
        return popularItemscategory.getText();
    }

    public void clickOnFirstItem() {
        driverWait.until(visibilityOf(firstItemImg));
        firstItemDescription.click();
    }
}