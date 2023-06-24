package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReviewProduct {
    WebDriver driver;

    public ReviewProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement product;

    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement allprod;

    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    WebElement viewprod;

    @FindBy(xpath = "//a[text()='Write Your Review']")
    WebElement Writereview;

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//textarea[@id='review']")
    WebElement review;

    @FindBy(xpath = "//button[@id='button-review']")
    WebElement submit;

    @FindBy(xpath = "//span[text()='Thank you for your review.']")
    WebElement Thankyou;

    public void review() throws InterruptedException {
        product.click();
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        product.click();
        Assert.assertTrue(allprod.isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        viewprod.click();
        JavascriptExecutor ads = (JavascriptExecutor) driver;
        ads.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");
        Assert.assertTrue(Writereview.isDisplayed());
        name.sendKeys("Sarvesh");
        email.sendKeys("sarveshkulkarni@gmail.com");
        review.sendKeys("Product quality is good");
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,250)", "");
        submit.click();
        Assert.assertTrue(Thankyou.isDisplayed());
    }
}
