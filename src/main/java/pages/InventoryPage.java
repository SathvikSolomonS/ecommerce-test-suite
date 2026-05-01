package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    // Locators
    private By pageTitle     = By.className("title");
    private By addToCartBtn  = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By cartIcon      = By.className("shopping_cart_link");
    private By cartBadge     = By.className("shopping_cart_badge");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public boolean isCartBadgeDisplayed() {
        return driver.findElements(cartBadge).size() > 0;
    }
}