package com.endava.soa4.context;

import com.endava.soa4.drivers.DriverManager;
import com.endava.soa4.drivers.DriverType;
import com.endava.soa4.pageobjects.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.endava.soa4.utils.PropertyLoader.getProperties;

public class TestContext {
    private WebDriver webDriver;
    private Home homePage;
    private Authentication authPage;
    private CreateAccount createAccountPage;
    private CreateAccountErrors newAccountErrors;
    private MyAccount myAccountPage;
    private ItemDetails myItemPage;
    public ScenarioContext scenarioContext;

    public TestContext() throws IOException {
        this.webDriver = DriverManager.getManager(DriverType.valueOf(getProperties("browser")));
        this.homePage = new Home(webDriver);
        this.authPage = new Authentication(webDriver);
        this.createAccountPage = new CreateAccount(webDriver);
        this.newAccountErrors = new CreateAccountErrors(webDriver);
        this.myAccountPage = new MyAccount(webDriver);
        this.myItemPage = new ItemDetails(webDriver);
        this.scenarioContext = new ScenarioContext();
    }

    public Home getHomePage() {
        return homePage;
    }

    public Authentication getAuthPage() {
        return authPage;
    }

    public CreateAccount getCreateAccountPage() {
        return createAccountPage;
    }

    public CreateAccountErrors getNewAccountErrors() {
        return newAccountErrors;
    }

    public MyAccount getMyAccountPage() {
        return myAccountPage;
    }

    public ItemDetails getMyItemPage() {
        return myItemPage;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}