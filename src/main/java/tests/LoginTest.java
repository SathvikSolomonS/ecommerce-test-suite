package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import utils.basetest;

public class LoginTest extends basetest {

    // Valid login test
    @Test(priority = 1)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }

    // Invalid login test
    @Test(priority = 2)
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong_user", "wrong_pass");

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    // Empty fields test
    @Test(priority = 3)
    public void testEmptyLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "");

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    // Data driven test - multiple users
    @Test(dataProvider = "userData", priority = 4)
    public void testMultipleUsers(String username, String password, boolean shouldPass) {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login(username, password);

        if (shouldPass) {
            Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed());
        }
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][] {
            { "standard_user",  "secret_sauce", true  },
            { "locked_out_user","secret_sauce", false },
            { "problem_user",   "secret_sauce", true  },
        };
    }
}