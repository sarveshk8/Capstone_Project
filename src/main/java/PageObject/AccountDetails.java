package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AccountDetails {

    WebDriver driver;

    public AccountDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    WebElement text;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement gender;

    @FindBy(xpath = "//input[@id='name']")
    WebElement name1;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    WebElement day;

    @FindBy(xpath = "//select[@id='months']")
    WebElement month;

    @FindBy(xpath = "//select[@id='years']")
    WebElement year;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement checkbox1;

    @FindBy(xpath = "//input[@id='optin']")
    WebElement checkbox2;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement Firstname;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement Lastname;

    @FindBy(xpath = "//input[@id='company']")
    WebElement Company;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement Address;

    @FindBy(xpath = "//input[@id='address2']")
    WebElement Address2;

    @FindBy(xpath = "//select[@id='country']")
    WebElement Country;

    @FindBy(xpath = "//input[@id='state']")
    WebElement state;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipcode;

    @FindBy(xpath = "//input[@id ='mobile_number']")
    WebElement mobile;

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement Creataccbtn;

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement visibletext;

    @FindBy(xpath = "(//a[@href='/'])[3]")
    WebElement continuebtn;


    @FindBy(xpath = "//a[text()=' Logged in as ']")
    WebElement textverify;


    public void accountdetails() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Sarvesh\\IdeaProjects\\Capstone_Axis\\src\\main\\java\\ProjectConfig\\config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        Assert.assertTrue(text.isDisplayed());
        gender.click();
        name1.clear();
        String namefield = prop.getProperty("Name");
        String passw = prop.getProperty("pass");
        name1.sendKeys(namefield);
        password.sendKeys(passw);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");


        String Day = prop.getProperty("Day");
        String Month = prop.getProperty("Month");
        String Year = prop.getProperty("Year");
        Select objSelect =new Select(day);
        objSelect.selectByVisibleText(Day);

        Select objSelect1 =new Select(month);
        objSelect1.selectByVisibleText(Month);

        Select objSelect2 =new Select(year);
        objSelect2.selectByVisibleText(Year);

        checkbox1.click();
        checkbox2.click();


        String fname = prop.getProperty("fname");
        String lname = prop.getProperty("lname");
        String compn = prop.getProperty("compn");
        String add1 = prop.getProperty("add1");
        String add2 = prop.getProperty("add2");
        Firstname.sendKeys(fname);
        Lastname.sendKeys(lname);
        Company.sendKeys(compn);
        Address.sendKeys(add1);
        Address2.sendKeys(add2);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)", "");

        Select objSelect3 =new Select(Country);
        objSelect3.selectByVisibleText("India");

        String State = prop.getProperty("State");
        String City = prop.getProperty("City");
        String Zipcode = prop.getProperty("Zipcode");
        String Mobile  = prop.getProperty("Mobile");
        state.sendKeys(State);
        city.sendKeys(City);
        zipcode.sendKeys(Zipcode);
        mobile.sendKeys(Mobile);
        Creataccbtn.click();


        Assert.assertTrue(visibletext.isDisplayed());

        continuebtn.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        continuebtn.click();

        Assert.assertTrue(textverify.isDisplayed());

    }




}

