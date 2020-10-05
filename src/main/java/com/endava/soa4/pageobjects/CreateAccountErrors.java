package com.endava.soa4.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountErrors extends CreateAccount {
    @FindBy(className = "alert-danger")
    private WebElement errorForm;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[1]")
    private WebElement phoneNumberError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[2]")
    private WebElement lastNameError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[3]")
    private WebElement firstNameError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[4]")
    private WebElement emailError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[5]")
    private WebElement passwordError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[6]")
    private WebElement aliasError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[7]")
    private WebElement addressError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[8]")
    private WebElement cityError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[9]")
    private WebElement zipError;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li[10]")
    private WebElement stateError;

    public CreateAccountErrors(WebDriver driver) {
        super(driver);
    }

    public String getPhoneNumberError() {
        return phoneNumberError.getText();
    }

    public String getLastNameError() {
        return lastNameError.getText();
    }

    public String getFirstNameError() {
        return firstNameError.getText();
    }

    public String getEmailError() {return emailError.getText();}

    public String getPasswordError() {
        return passwordError.getText();
    }

    public String getAliasError() {
        return aliasError.getText();
    }

    public String getAddressError() {
        return addressError.getText();
    }

    public String getCityError() {
        return cityError.getText();
    }

    public String getZipError() {
        return zipError.getText();
    }

    public String getStateError() {
        return stateError.getText();
    }
}