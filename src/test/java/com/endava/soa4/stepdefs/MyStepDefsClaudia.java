package com.endava.soa4.stepdefs;

import com.endava.soa4.drivers.DriverManager;
import com.endava.soa4.drivers.DriverType;
import com.endava.soa4.pageobjects.CategoryPage;
import com.endava.soa4.pageobjects.HomePage;

import com.endava.soa4.pageobjects.ShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.endava.soa4.utils.PropertyLoader.getProperties;

public class MyStepDefsClaudia {
    WebDriver driver;

    {
        try {
            driver = DriverManager.getManager(DriverType.valueOf(getProperties("browser")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    HomePage homePage = new HomePage(driver);

    CategoryPage categoryPage = new CategoryPage(driver);

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

    Actions action = new Actions(driver);

    @Given("user is on Home page")
    public void userIsOnHomePage() {
        System.out.println("Check the home page url");
        Assert.assertEquals(homePage.getUrl(), driver.getCurrentUrl());
    }

    @When("user navigates to {string} items page")
    public void userNavigatesToSpecificItemsPage(String item) {
        homePage.getHeading().stream().filter(e -> e.getText().equals(item)).findFirst().get().click();
        driver.getCurrentUrl();

    }

    @When("user clicks on Add to card button for item")
    public void userClicksOnAddToCardButtonForItem(List<String> prices) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        for (String priceItem : prices) {
            TimeUnit.SECONDS.sleep(2);
            var item = categoryPage.getItems()
                    .stream().filter(i -> i.findElement(By.cssSelector("div>div:nth-child(2)>div>span:nth-child(1)"))
                            .getText().equals(priceItem))
                    .findFirst().get();
            action.moveToElement(item).perform();
            item.findElement(By.cssSelector("div>div .ajax_add_to_cart_button")).click();
        }
    }

    @Then("a pop up window is displayed with message {string}")
    public void aPopUpWindowIsDisplayedWithMessage(String title) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals("Pop-up title doesn't match the expected one", title, categoryPage.getPopUpTitle().getText());
    }

    @Then("item details are displayed on pop-up")
    public void itemDetailsAreDisplayed() {

        Assert.assertTrue("Product title is not displayed ", categoryPage.getProductTitle().isDisplayed());
        System.out.println("Product title is displayed: " + categoryPage.getProductTitle().getText());

        Assert.assertTrue("Product info is not displayed ", categoryPage.getProductInfo().isDisplayed());
        System.out.println("Product info is displayed: " + categoryPage.getProductInfo().getText());

        Assert.assertTrue("Product quantity is not displayed ", categoryPage.getProductQuantity().isDisplayed());
        System.out.println("Product quantity is displayed: " + categoryPage.getProductQuantity().getText());

        Assert.assertTrue("Product price is not displayed ", categoryPage.getProductPrice().isDisplayed());
        System.out.println("Product price is displayed: " + categoryPage.getProductPrice().getText());
    }

    @When("user clicks on Proceed to checkout button")
    public void userClicksOnProceedToCheckoutButton() {
        categoryPage.getCheckoutButton().click();
    }

    @Then("Shopping-cart summary page is displayed")
    public void shoppingCartSummaryPageIsDisplayed() {
        System.out.println("Shopping cart page is displayed");
        Assert.assertEquals(shoppingCartPage.getUrl(), driver.getCurrentUrl());
    }

    @Then("added item is in shopping cart")
    public void addedItemIsInShoppingCart(String price) {
        var priceIsDisplayed = shoppingCartPage.getUnitPriceItemCart()
                .stream().filter(i -> i.getText().equals(price))
                .findFirst().get().isDisplayed();
        Assert.assertTrue(String.format("Item with price %s is not displayed", price), priceIsDisplayed);
    }

    @When("user adds items with following price")
    public void userAddsItemsWithFollowingPrice(List<String> price) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        for (String priceItem : price) {
            var item = categoryPage.getItems()
                    .stream().filter(i -> i.findElement(By.cssSelector("div>div:nth-child(2)>div>span:nth-child(1)"))
                            .getText().equals(priceItem))
                    .findFirst().get();
            action.moveToElement(item).perform();
            item.findElement(By.cssSelector("div>div .ajax_add_to_cart_button")).click();
            TimeUnit.SECONDS.sleep(3);
            categoryPage.getClosePopUpButton().click();
        }
    }

    @Then("user navigates to shopping cart page")
    public void userNavigatesToShoppingCartPage() {
        categoryPage.getShoppingCartButton().click();
    }

    @Then("Shopping cart summary page is displayed")
    public void pageIsDisplayed() {
        Assert.assertEquals(shoppingCartPage.getUrl(), driver.getCurrentUrl());
    }

    @When("user clicks on [delete] button for item with price {string}")
    public void userClicksOnDeleteButtonForItemWithPrice$(String price) {
        shoppingCartPage.getCartItem()
                .stream().filter(i -> i.findElement(By.cssSelector(("span.price>span")))
                .getText().equals(price))
                .findFirst().get()
                .findElement(By.cssSelector("a[title=Delete")).click();
    }

    @Then("the item with price {string} is deleted from the list")
    public void theItemIsDeletedFromTheList(String price) {
        var priceIsNotDisplayed = shoppingCartPage.getCartItem()
                .stream().filter(i -> i.findElement(By.cssSelector(("span.price>span")))
                        .getText().equals(price))
                .findFirst().get().isDisplayed();
        Assert.assertTrue(String.format("Item with price %s is displayed", price), priceIsNotDisplayed);
    }

    @Then("the total values are")
    public void theTotalValuesAre(List<Map<String, String>> dataTable) throws IllegalAccessException, InterruptedException {
        for (Map<String, String> row : dataTable) {
            TimeUnit.SECONDS.sleep(2);
            var field = row.get("Field");
            var value = row.get("Value");
            var actual = shoppingCartPage.getElement(field).getText();
            Assert.assertTrue(String.format("The values of %s is not matching the expected values", field), actual.equalsIgnoreCase(value));
        }
    }

    @When("user press on {string} button for item with price {string}")
    public void userPressOnButtonForItemWithPrice$(String option, String price) {
        if (option.equals("+")) {
            shoppingCartPage.getCartItem()
                    .stream().filter(i -> i.findElement(By.cssSelector(("span.price>span")))
                    .getText().equals(price))
                    .findFirst().get()
                    .findElement(By.cssSelector("a.button-plus")).click();
        } else if (option.equals("-")) {
            shoppingCartPage.getCartItem()
                    .stream().filter(i -> i.findElement(By.cssSelector(("span.price>span")))
                    .getText().equals(price))
                    .findFirst().get()
                    .findElement(By.cssSelector("a.button-minus")).click();
        }
    }

    @Then("the quantity of item with price {string} is changed to {string}")
    public void theQuantityOfItemWithPrice$IsChangedTo(String price, String quantity) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        var actualQuantity = shoppingCartPage.getCartItem()
                .stream().filter(i -> i.findElement(By.cssSelector(("span.price>span")))
                        .getText().equals(price))
                .findFirst().get()
                .findElement(By.cssSelector(".cart_quantity_input")).getAttribute("value");
        Assert.assertEquals("The actual quantity is not matching with expected quantity", quantity, actualQuantity);
    }
}