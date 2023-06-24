package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement Signup;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement pass;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    WebElement text;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement login;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    WebElement visibletext;

    @FindBy(xpath = "//a[text()=' Logout']")
    WebElement logout;

    public void loginvalid() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Sarvesh\\IdeaProjects\\Capstone_Axis\\src\\main\\java\\ProjectConfig\\config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        Signup.click();
        Assert.assertTrue(text.isDisplayed());
        String emailid = prop.getProperty("emailid");
        String passwd = prop.getProperty("passwd");
        email.sendKeys(emailid);
        pass.sendKeys(passwd);
        login.click();
        Assert.assertTrue(visibletext.isDisplayed());
        logout.click();
        Assert.assertTrue(Signup.isDisplayed());

    }

    public void logininvalid() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Sarvesh\\IdeaProjects\\Capstone_Axis\\src\\main\\java\\ProjectConfig\\config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String emailadd = prop.getProperty("email");
        String pass1 = prop.getProperty("pass1");
        Signup.click();
        Assert.assertTrue(text.isDisplayed());
        email.sendKeys(emailadd);
        pass.sendKeys(pass1);
        login.click();

    }

}
