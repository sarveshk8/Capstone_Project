package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchProduct {

    WebDriver driver;

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//a[@href='/products']")
    WebElement product;

    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement allprod;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement inputprod;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchbtn;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    WebElement searchedprod;

    @FindBy(xpath = "(//a[text()='Add to cart'])[1]")
    WebElement add1;

    @FindBy(xpath = "(//a[text()='Add to cart'])[3]")
    WebElement add2;

    @FindBy(xpath = "(//a[text()='Add to cart'])[5]")
    WebElement add3;

    @FindBy(xpath = "(//a[text()='Add to cart'])[7]")
    WebElement add4;

    @FindBy(xpath = "(//a[text()='Add to cart'])[9]")
    WebElement add5;

    @FindBy(xpath = "(//a[text()='Add to cart'])[11]")
    WebElement add6;

    @FindBy(xpath = "(//a[text()='Add to cart'])[13]")
    WebElement add7;

    @FindBy(xpath = "(//a[text()='Add to cart'])[15]")
    WebElement add8;

    @FindBy(xpath = "(//a[text()='Add to cart'])[17]")
    WebElement add9;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement contbtn;

    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
    WebElement cart;

    @FindBy(xpath = "//a[text()='Sleeveless Dress']")
    WebElement p1;

    @FindBy(xpath = "//a[text()='Stylish Dress']")
    WebElement p2;

    @FindBy(xpath = "//a[text()='Sleeves Top and Short - Blue & Pink']")
    WebElement p3;

    @FindBy(xpath = "//a[text()='Sleeveless Unicorn Patch Gown - Pink']")
    WebElement p4;

    @FindBy(xpath = "//a[text()='Cotton Mull Embroidered Dress']")
    WebElement p5;

    @FindBy(xpath = "//a[text()='Blue Cotton Indie Mickey Dress']")
    WebElement p6;

    @FindBy(xpath = "//a[text()='Long Maxi Tulle Fancy Dress Up Outfits -Pink']")
    WebElement p7;

    @FindBy(xpath = "//a[text()='Sleeveless Unicorn Print Fit & Flare Net Dress - Multi']")
    WebElement p8;

    @FindBy(xpath = "//a[text()='Rose Pink Embroidered Maxi Dress']")
    WebElement p9;

    public void serarchp() throws InterruptedException {

        product.click();

        JavascriptExecutor ads = (JavascriptExecutor) driver;
        ads.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");

        product.click();

        allprod.isDisplayed();
        Assert.assertTrue(allprod.isDisplayed());

        inputprod.sendKeys("dress");
        searchbtn.click();

        searchedprod.isDisplayed();
        Assert.assertTrue(searchedprod.isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");

        Actions act = new Actions(driver);
        act.moveToElement(add1).click().build().perform();
        contbtn.click();
        act.moveToElement(add2).click().build().perform();
        contbtn.click();
        act.moveToElement(add3).click().build().perform();
        contbtn.click();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,600)", "");
        act.moveToElement(add4).click().build().perform();
        contbtn.click();
        act.moveToElement(add5).click().build().perform();
        contbtn.click();
        Thread.sleep(1000);
        act.moveToElement(add6).click().build().perform();
        contbtn.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,550)", "");
        act.moveToElement(add7).click().build().perform();
        contbtn.click();
        act.moveToElement(add8).click().build().perform();
        contbtn.click();
        act.moveToElement(add9).click().build().perform();
        contbtn.click();

        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,-1600)", "");
    }

    public void prodDisplay(){


        cart.click();

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,450)", "");

        Assert.assertTrue(p1.isDisplayed());
        Assert.assertTrue(p2.isDisplayed());
        Assert.assertTrue(p3.isDisplayed());
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,450)", "");
        Assert.assertTrue(p4.isDisplayed());
        Assert.assertTrue(p5.isDisplayed());
        Assert.assertTrue(p6.isDisplayed());
        JavascriptExecutor js6 = (JavascriptExecutor) driver;
        js6.executeScript("window.scrollBy(0,450)", "");
        Assert.assertTrue(p7.isDisplayed());
        Assert.assertTrue(p8.isDisplayed());
        Assert.assertTrue(p9.isDisplayed());


    }

}
