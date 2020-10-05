package com.endava.soa4.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CreateAccount extends Page {
    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
    private WebElement createAccountFormName;
    @FindBy(id = "customer_firstname")
    private WebElement firstName;
    @FindBy(id = "customer_lastname")
    private WebElement lastName;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "firstname")
    private WebElement firstNameAgain;
    @FindBy(id = "lastname")
    private WebElement lastNameAgain;
    @FindBy(id = "address1")
    private WebElement addressOne;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "id_state")
    private Select state;
    @FindBy(id = "postcode")
    private WebElement zipCode;
    @FindBy(id = "id_country")
    private Select country;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;
    @FindBy(id = "alias")
    private WebElement addressAlias;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    public String getCreateAccountFormName() {
        driverWait.until(visibilityOf(createAccountFormName));
        return createAccountFormName.getText();
    }

    private void setState(Map<String, String> dataTable) {
        state = new Select(driverWait
                .until(webDriver -> webDriver.findElement(By.id("id_state"))));
        if (dataTable.get("State") == null) {
            state.deselectAll();
        } else {
            state.selectByVisibleText(dataTable.get("State"));
        }
    }

    private void setCountry(Map<String, String> dataTable) {
        country = new Select(driverWait
                .until(webDriver -> webDriver.findElement(By.id("id_country"))));
        country.selectByVisibleText(dataTable.get("Country"));
    }

    public void fillInFields(Map<String, String> dataTable) {
        firstName.sendKeys(dataTable.get("First name"));
        lastName.sendKeys(dataTable.get("Last name"));
        password.sendKeys(dataTable.get("Password"));
        firstNameAgain.clear();
        firstNameAgain.sendKeys(dataTable.get("First name from address"));
        lastNameAgain.clear();
        lastNameAgain.sendKeys(dataTable.get("Last name from address"));
        addressOne.sendKeys(dataTable.get("Address"));
        city.sendKeys(dataTable.get("City"));
        setState(dataTable);
        zipCode.sendKeys(dataTable.get("Zip/Postal Code"));
        setCountry(dataTable);
        mobilePhone.sendKeys(dataTable.get("Mobile phone"));
        addressAlias.clear();
        addressAlias.sendKeys(dataTable.get("Assign an address alias for future reference."));
    }

    public void fillInEmail(Map<String, String> dataTable, String generatedEmail) {
        email.clear();
        if (!(dataTable.get("Email").equalsIgnoreCase("random"))) {
            email.sendKeys(dataTable.get("Email"));
        } else {
            email.sendKeys(generatedEmail);
        }
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}