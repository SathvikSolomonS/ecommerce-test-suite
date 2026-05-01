package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import utils.basetest;

public class CartTest extends basetest {

    // Add item to cart test
    @Test(priority = 1)
    public void testAddItemToCart() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();

        Assert.assertTrue(inventoryPage.isCartBadgeDisplayed());
        Assert.assertEquals(inventoryPage.getCartCount(), "1");
    }

    // Go to cart test
    @Test(priority = 2)
    public void testGoToCart() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        Assert.assertEquals(cartPage.getPageTitle(), "Your Cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1);
    }

    // Remove item from cart test
    @Test(priority = 3)
    public void testRemoveItemFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();
        cartPage.removeItem();

        Assert.assertEquals(cartPage.getCartItemCount(), 0);
    }
}