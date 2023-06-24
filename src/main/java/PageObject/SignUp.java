package PageObject;

import org.Configurations.BaseConfiguration;
import org.Configurations.FileInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SignUp  {
    WebDriver driver;

    public SignUp(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement Signup;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement Signupvisible;

    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    WebElement email;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupbtn;


    public static String email() {

        String emailAddress = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (emailAddress.length() < 5) {
            int character = (int) (Math.random() * 26);
            emailAddress += alphabet.substring(character, character + 1);
            emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
            emailAddress += "@" + "gmail"+".com";



        }
        return emailAddress;
    }


    public  void signup() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Sarvesh\\IdeaProjects\\Capstone_Axis\\src\\main\\java\\ProjectConfig\\config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String Email = email();
        Signup.click();
        Assert.assertTrue(Signupvisible.isDisplayed());
        String namestr = prop.getProperty("name");
        name.sendKeys(namestr);
        email.sendKeys(Email);
        signupbtn.click();
    }

}
