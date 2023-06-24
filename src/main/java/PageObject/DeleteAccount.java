package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteAccount {

    WebDriver driver;
    public DeleteAccount(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }

    @FindBy(xpath = "//a[text()=' Delete Account']")
    WebElement delete;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement delaccvisible;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement contbtn;

    public void deleteacc(){

        delete.click();
        Assert.assertTrue(delaccvisible.isDisplayed());
        contbtn.click();

    }


}


