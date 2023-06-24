package org.example;

import PageObject.Login;
import PageObject.ReviewProduct;
import PageObject.SearchProduct;
import org.Configurations.BaseConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Review extends BaseConfiguration {

    WebDriver driver;
    ReviewProduct reviewobj;


    @Parameters({"Port"})
    @BeforeMethod
    public void initializeSetup(String Port) throws IOException {
        driver = setup(Port);
        reviewobj = new ReviewProduct(driver);


    }
    @Test
    public void test1() throws IOException, InterruptedException {

        reviewobj.review();

    }
}
