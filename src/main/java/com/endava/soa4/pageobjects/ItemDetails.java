package com.endava.soa4.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ItemDetails extends Home {
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
    private WebElement productName;
    @FindBy(className = "open-comment-form")
    private WebElement addReviewButton;
    @FindBy(xpath = "//*[@id=\"id_new_comment_form\"]/h2")
    private WebElement newReviewFormName;
    @FindBy(xpath = "//*[@id=\"criterions_list\"]/li/div[1]/div[6]/a")
    private WebElement voteFiveStars;
    @FindBy(id = "comment_title")
    private WebElement commentTitle;
    @FindBy(id = "content")
    private WebElement commentText;
    @FindBy(xpath = "//*[@id=\"submitNewMessage\"]/span")
    private WebElement sendButton;
    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/div/p[1]")
    private WebElement popUpForm;

    public ItemDetails(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        driverWait.until(visibilityOf(productName));
        return productName.getText();
    }

    public void clickOnAddNewReview(){
        driverWait.until(visibilityOf(addReviewButton));
        addReviewButton.click();
    }

    public String getNewReviewFormName(){
        driverWait.until(visibilityOf(newReviewFormName));
        return newReviewFormName.getText();
    }

    public void clickOnVoteFiveStars(){
        voteFiveStars.click();
    }

    public void enterTitle(){
        commentTitle.sendKeys("Wonderful dress");
    }

    public void enterCommentText(){
        commentText.sendKeys("Waiting for other colors");
    }

    public void clickOnSendButton(){
        sendButton.click();
    }

    public void successfullCommentAddedPopUp(){
        driverWait.until(visibilityOf(popUpForm));
        popUpForm.isDisplayed();
    }

    public String getPopUpMessage(){
        return popUpForm.getText();
    }
}