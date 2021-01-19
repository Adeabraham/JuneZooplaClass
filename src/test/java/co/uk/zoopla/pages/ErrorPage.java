package co.uk.zoopla.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage extends BasePage
{
    //creating a constructor:
    public ErrorPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (tagName = "h1")
    private WebElement errorPageTitle;

    public void isErrorPageDisplayed()
    {
        String errorTitle = errorPageTitle.getText();
        Assert.assertTrue(errorTitle.contains("Sorry, we could not find a place name matching"));
    }
}
