package com.endava.soa4.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage {
    WebDriver driverManager;

    public CategoryPage(WebDriver driverManager) {
        this.driverManager = driverManager;
        PageFactory.initElements(driverManager, this);
    }

    @Getter
    @FindBy(css = ".product_list>li")
    private List<WebElement> items;

    @Getter
    @FindBy(css = ".cross")
    private WebElement closePopUpButton;

    @Getter
    @FindBy(css = "#layer_cart div>h2:nth-child(2)")
    private WebElement popUpTitle;

    @Getter
    @FindBy(css = "div.layer_cart_product_info span.product-name")
    private WebElement productTitle;

    @Getter
    @FindBy(css = "#layer_cart_product_attributes")
    private WebElement productInfo;

    @Getter
    @FindBy(css = "#layer_cart_product_quantity")
    private WebElement productQuantity;

    @Getter
    @FindBy(css = "#layer_cart_product_price")
    private WebElement productPrice;

    @FindBy(css = "div>div .ajax_add_to_cart_button")
    public WebElement adToCart;

    @Getter
    @FindBy(css = "a[title=\"Proceed to checkout\"]")
    private WebElement checkoutButton;

    @Getter
    @FindBy(css = "a[title=\"View my shopping cart\"]")
    private WebElement shoppingCartButton;

}
