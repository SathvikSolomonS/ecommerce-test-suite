package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By pageTitle        = By.className("title");
    private By cartItems        = By.className("cart_item");
    private By removeButton     = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    private By checkoutButton   = By.cssSelector("[data-test='checkout']");
    private By continueShopBtn  = By.cssSelector("[data-test='continue-shopping']");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeItem() {
        driver.findElement(removeButton).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void continueShopping() {
        driver.findElement(continueShopBtn).click();
    }
}