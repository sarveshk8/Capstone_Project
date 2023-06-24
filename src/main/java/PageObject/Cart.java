package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cart {
    WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "(//*[text()='Add to cart'])[1]")
    WebElement add1;

    @FindBy(xpath = "(//*[text()='Add to cart'])[3]")
    WebElement add2;

    @FindBy(xpath = "(//*[text()='Add to cart'])[5]")
    WebElement add3;

    @FindBy(xpath = "(//*[text()='Add to cart'])[7]")
    WebElement add4;

    @FindBy(xpath = "(//*[text()='Add to cart'])[9]")
    WebElement add5;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement contbtn;

    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
    WebElement cart;

    @FindBy(xpath = "//i[@class='fa fa-times'][1]")
    WebElement rem1;

    @FindBy(xpath = "(//i[@class='fa fa-times'])[1]")
    WebElement rem2;

    @FindBy(xpath = "(//a[@class='cart_quantity_delete'])[1]")
    WebElement rem3;

    @FindBy(xpath = "(//a[@class='cart_quantity_delete'])[1]")
    WebElement rem4;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement rem5;

    @FindBy(xpath = "//span[@id='empty_cart']")
    WebElement emptycart;

    public void addtocart(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        Actions act = new Actions(driver);
        act.moveToElement(add1).click().build().perform();
        contbtn.click();
        act.moveToElement(add2).click().build().perform();
        contbtn.click();
        act.moveToElement(add3).click().build().perform();
        contbtn.click();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)", "");


        act.moveToElement(add4).click().build().perform();
        contbtn.click();
        act.moveToElement(add5).click().build().perform();
        contbtn.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,-1000)", "");

        cart.click();
    }

    public void removecart() throws InterruptedException {

        rem1.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-times'])[1]")));
        rem2.click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='cart_quantity_delete'])[1]")));
        rem3.click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='cart_quantity_delete'])[1]")));
        rem4.click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cart_quantity_delete']")));
        rem5.click();
        Thread.sleep(1000);
        Assert.assertTrue(emptycart.isDisplayed());
    }
}
