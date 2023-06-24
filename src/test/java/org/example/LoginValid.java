package org.example;

import PageObject.*;
import org.Configurations.BaseConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginValid extends BaseConfiguration {

    WebDriver driver;
    Login loginobj;
    HomePage homePageobj;

    @Parameters({"Port"})
    @BeforeMethod
    public void initializeSetup(String Port) throws IOException {
        driver = setup(Port);
        loginobj = new Login(driver);
        homePageobj = new HomePage(driver);


    }
    @Test
    public void test1() throws IOException, InterruptedException {

        homePageobj.homepage();
        loginobj.loginvalid();


    }


}
