package com.endava.soa4.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MyAccount extends Page {
    @FindBy(className = "page-heading")
    private WebElement title;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    private WebElement actualUsername;
    @FindBy(className = "logo")
    private WebElement logoImg;
    private boolean userLoggedIn;

    public MyAccount(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        driverWait.until(visibilityOf(title));
        return title.getText();
    }

    public String getActualUsername() {
        return actualUsername.getText();
    }

    public boolean checkUsernameIsPresent() {
        try {
            if (actualUsername.isDisplayed()) {
                return userLoggedIn = true;
            }
        } catch (NoSuchElementException e) {
            return userLoggedIn = false;
        }
        return userLoggedIn;
    }

    public void navigateToHomePage() {
        driverWait.until(visibilityOf(logoImg));
        logoImg.click();
    }
}