package VerifySucessfullTests;

import Automation.SeleniumBase;
import Pages.LoginPage;
import Pages.ProductsPage;
import Utilities.SeleniumActions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyLoginTest extends SeleniumBase {
    public LoginPage loginPage;
    public ProductsPage productsPage;

    @BeforeClass
    public void initialize(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void verifyLogin(){
        loginPage.login("standard_user","secret_sauce");
       String heading = productsPage.getProductsHeading();
        Assert.assertEquals(heading,"Products");
    }
}
