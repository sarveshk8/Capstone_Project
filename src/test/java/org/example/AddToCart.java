package org.example;

import PageObject.Cart;
import PageObject.HomePage;
import PageObject.Login;
import org.Configurations.BaseConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCart extends BaseConfiguration {

    WebDriver driver;

    Cart cartobj;
    HomePage homePageobj;

    @Parameters({"Port"})
    @BeforeMethod
    public void initializeSetup(String Port) throws IOException {
        driver = setup(Port);
        cartobj = new Cart(driver);
        homePageobj = new HomePage(driver);


    }
    @Test
    public void test1() throws IOException, InterruptedException {

        homePageobj.homepage();
        cartobj.addtocart();
        cartobj.removecart();


    }
}
