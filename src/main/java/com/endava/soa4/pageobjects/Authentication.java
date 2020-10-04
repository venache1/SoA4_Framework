package com.endava.soa4.pageobjects;

import com.endava.soa4.utils.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Authentication extends Page {
    @FindBy(className = "page-heading")
    private WebElement authenticationHeading;
    @FindBy(id = "email_create")
    private WebElement newEmailInputField;
    @FindBy(id = "email")
    private WebElement existentEmailInputField;
    @FindBy(id = "passwd")
    private WebElement existentPassword;
    @FindBy(id = "SubmitLogin")
    private WebElement logInButton;

    public Authentication(WebDriver driver) {
        super(driver);
    }

    public String generateNewEmail() {
        Random random = new Random();
        int number = random.nextInt(1000) + 1;
        String emailAddress = "registest" + number + "@mailinator.com";
        return emailAddress;
    }

    public void submitNewEmail(String email) {
        driverWait.until(visibilityOf(authenticationHeading));
        newEmailInputField.sendKeys(email);
        newEmailInputField.submit();
    }

    public void logInWithExistentUser() throws IOException {
        driverWait.until(visibilityOf(authenticationHeading));
        existentEmailInputField.sendKeys(PropertyLoader.getProperties("emailIrina"));
        existentPassword.sendKeys(PropertyLoader.getProperties("passwordIrina"));
        logInButton.click();
    }
}