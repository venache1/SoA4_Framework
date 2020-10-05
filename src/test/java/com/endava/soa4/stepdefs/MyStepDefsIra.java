package com.endava.soa4.stepdefs;

import com.endava.soa4.context.Context;
import com.endava.soa4.context.TestContext;
import com.endava.soa4.pageobjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class MyStepDefsIra {
    private Home homePage;
    private Authentication authPage;
    private CreateAccount createAccountPage;
    private CreateAccountErrors newAccountErrors;
    private MyAccount myAccountPage;
    private ItemDetails myItemPage;
    private TestContext testContext;

    public MyStepDefsIra(TestContext context) {
        testContext = context;
        homePage = testContext.getHomePage();
        authPage = testContext.getAuthPage();
        createAccountPage = testContext.getCreateAccountPage();
        newAccountErrors = testContext.getNewAccountErrors();
        myAccountPage = testContext.getMyAccountPage();
        myItemPage = testContext.getMyItemPage();
    }

    @Given("user is on Create Account page")
    public void userIsOnCreateAccountPage() {
        homePage.clickOnSignIn();
        String newEmail = authPage.generateNewEmail();
        testContext.scenarioContext.setContext(Context.USEREMAIL, newEmail);
        authPage.submitNewEmail(newEmail);
        Assert.assertEquals("YOUR PERSONAL INFORMATION", createAccountPage.getCreateAccountFormName());
    }

    @When("user enters data into fields:")
    public void userEntersDataIntoFields(Map<String, String> dataTable) {
        createAccountPage.fillInFields(dataTable);
        String generatedName = (String) testContext.getScenarioContext().getContext(Context.USEREMAIL);
        createAccountPage.fillInEmail(dataTable, generatedName);
    }

    @When("user clicks on Register button")
    public void userClicksOnRegisterButton() {
        createAccountPage.clickRegisterButton();
    }

    @Then("My Account page is displayed")
    public void myAccountPageIsDisplayed() {
        Assert.assertEquals("MY ACCOUNT", myAccountPage.getPageTitle());
    }

    @Then("John Smitherson is displayed in Navigation bar")
    public void johnSmithersonIsDisplayedInNavigationBar() {
        Assert.assertEquals("John Smitherson", myAccountPage.getActualUsername());
    }

    @Then("Create Account page is displayed")
    public void createAccountPageIsDisplayed() {
        Assert.assertEquals("YOUR PERSONAL INFORMATION", createAccountPage.getCreateAccountFormName());
    }

    @Then("Arr{int} {int}Alkim is not displayed in Navigation bar")
    public void arrAlkimIsNotDisplayedInNavigationBar(int arg0, int arg1) {
        Assert.assertFalse(myAccountPage.checkUsernameIsPresent());
    }

    @Then("errors are displayed:")
    public void errorsAreDisplayed(Map<String, String> expectedErrors) {
        Assert.assertEquals(expectedErrors.get("Phone error"), newAccountErrors.getPhoneNumberError());
        Assert.assertEquals(expectedErrors.get("Last name error"), newAccountErrors.getLastNameError());
        Assert.assertEquals(expectedErrors.get("First name error"), newAccountErrors.getFirstNameError());
        Assert.assertEquals(expectedErrors.get("Password error"), newAccountErrors.getPasswordError());
        Assert.assertEquals(expectedErrors.get("Email error"), newAccountErrors.getEmailError());
        Assert.assertEquals(expectedErrors.get("Alias error"), newAccountErrors.getAliasError());
        Assert.assertEquals(expectedErrors.get("Address error"), newAccountErrors.getAddressError());
        Assert.assertEquals(expectedErrors.get("City error"), newAccountErrors.getCityError());
        Assert.assertEquals(expectedErrors.get("Zip error"), newAccountErrors.getZipError());
        Assert.assertEquals(expectedErrors.get("State error"), newAccountErrors.getStateError());
    }

    @Given("user is logged in app")
    public void userIsLoggedInApp() throws IOException {
        homePage.clickOnSignIn();
        authPage.logInWithExistentUser();
        Assert.assertEquals("MY ACCOUNT", myAccountPage.getPageTitle());
        Assert.assertTrue(myAccountPage.checkUsernameIsPresent());
    }

    @When("user navigates to Home page")
    public void userNavigatesToHomePage() {
        myAccountPage.navigateToHomePage();
        Assert.assertEquals("POPULAR", homePage.getPopularItemscategory());
    }

    @When("user clicks on item{int}")
    public void userClicksOnItem(int arg0) {
        homePage.clickOnFirstItem();
        Assert.assertEquals("Faded Short Sleeve T-shirts", myItemPage.getProductName());
    }

    @When("user clicks on Write a review")
    public void userClicksOnWriteAReview() {
        myItemPage.clickOnAddNewReview();
        Assert.assertEquals("WRITE A REVIEW", myItemPage.getNewReviewFormName());
    }

    @When("user clicks on Quality {int} stars")
    public void userClicksOnQualityStars(int arg0) {
        myItemPage.clickOnVoteFiveStars();
    }

    @When("user enters Wonderful dress text in Title field")
    public void userEntersWonderfulDressTextInTitleField() {
        myItemPage.enterTitle();
    }

    @When("user enters Waiting for other colors text in Comment field")
    public void userEntersWaitingForOtherColorsTextInCommentField() {
        myItemPage.enterCommentText();
    }

    @When("user clicks on Send button")
    public void userClicksOnSendButton() {
        myItemPage.clickOnSendButton();
    }

    @Then("New comment pop-up is displayed")
    public void newCommentPopUpIsDisplayed() {
        myItemPage.successfullCommentAddedPopUp();
        Assert.assertEquals("Your comment has been added and will be available once approved by a moderator", myItemPage.getPopUpMessage());
    }
}