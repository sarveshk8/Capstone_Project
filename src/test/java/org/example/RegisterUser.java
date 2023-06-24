package org.example;

import PageObject.AccountDetails;
import PageObject.DeleteAccount;
import PageObject.HomePage;
import PageObject.SignUp;
import org.Configurations.BaseConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class RegisterUser extends BaseConfiguration {
    HomePage homepageobj;
    SignUp signupobj;
    AccountDetails accountdetailobj;
    DeleteAccount deleteaccountobj;


    WebDriver driver;

    @Parameters({"Port"})
    @BeforeMethod
    public void initializeSetup(String Port) throws IOException {
        driver = setup(Port);
        homepageobj = new HomePage(driver);
        signupobj = new SignUp(driver);
        accountdetailobj = new AccountDetails(driver);
        deleteaccountobj = new DeleteAccount(driver);


    }
    @Test
    public void test1() throws IOException, InterruptedException {

        homepageobj.homepage();
        signupobj.signup();
        accountdetailobj.accountdetails();
        deleteaccountobj.deleteacc();


    }
}
