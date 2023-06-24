package org.example;

import PageObject.Cart;
import PageObject.HomePage;
import PageObject.Login;
import PageObject.SearchProduct;
import org.Configurations.BaseConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Search extends BaseConfiguration {
    WebDriver driver;

   SearchProduct searchobj;
   Login loginobj1;

    @Parameters({"Port"})
    @BeforeMethod
    public void initializeSetup(String Port) throws IOException {
        driver = setup(Port);
        searchobj = new SearchProduct(driver);
        loginobj1 = new Login(driver);


    }
    @Test
    public void test1() throws IOException, InterruptedException {

        searchobj.serarchp();
        searchobj.prodDisplay();
        loginobj1.loginvalid();
        searchobj.prodDisplay();

    }
}
