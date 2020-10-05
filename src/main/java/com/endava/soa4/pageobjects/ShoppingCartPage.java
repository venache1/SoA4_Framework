package com.endava.soa4.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {
    WebDriver driverManager;

    public ShoppingCartPage(WebDriver driverManager) {
        this.driverManager = driverManager;
        PageFactory.initElements(driverManager, this);
    }

    @Getter
    String url = "http://automationpractice.com/index.php?controller=order";

    @Getter
    @FindBy(css = "span.price>span")
    private List<WebElement> unitPriceItemCart;

    @Getter
    @FindBy(css = ".cart_item")
    private List<WebElement> cartItem;

    @Getter
    @FindBy(css = "a[title=Delete]")
    private WebElement deleteItemButton;

    @Getter
    @FindBy(css = ".price#total_product")
    private WebElement totalProducts;

    @Getter
    @FindBy(css = "#total_shipping")
    private WebElement totalShipping;

    @Getter
    @FindBy(css = "#total_price_without_tax")
    private WebElement totalPriceWithoutTax;

    @Getter
    @FindBy(css = "#total_tax")
    private WebElement tax;

    @Getter
    @FindBy(css = "#total_price")
    private WebElement total;

    @Getter
    @FindBy(css = "a.button-plus")
    private WebElement plusButton;

    @Getter
    @FindBy(css = "a.button-minus")
    private WebElement minusButton;

    @Getter
    @FindBy(css = ".cart_quantity_input")
    private WebElement itemQuantity;

    public WebElement getElement(String name) throws IllegalAccessException {
        for (var field : getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase(name.replaceAll("\\s", ""))) {
                return (WebElement) field.get(this);
            }
        }
        return null;
    }
}
