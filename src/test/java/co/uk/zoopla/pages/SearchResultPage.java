package co.uk.zoopla.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class SearchResultPage extends BasePage
{
    //creating a constructor:
    public SearchResultPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".css-mh5azd-Heading1.e1s8jdjv5")
    private WebElement pageTitle;
    @FindBy(css = ".css-1d37cx5-Text-StyledPropertyPrice.e1iw5dxq6")
    private List<WebElement> results; //we use List because the result is more than 1. It is an
                                     // instruction to selenium to expect many webelements

    public void isSearchResultPageDisplayed(String location)
    {
        String url = driver.getCurrentUrl();//this will get the Url, saved into a variable called url
        //to verify:
        Assert.assertTrue(url.contains(location));//I want to assertTrue
                                                   // that this url contains location
    }

    // to get the text of the pageTitle (for validation)
     public void doesPageTitleContain(String location)
    {
      String title = pageTitle.getText();//getText will extract the title from a webElement
        Assert.assertTrue(title.contains(location));
     //String title = pageTitle.getText().toLowerCase(); //get this text and convert
                 // to lower case. We are using this as a further measure to intentionationally
             // make the test to fail. It starts with a capital letter but we change everything to
             // lower letters for Java to pick it up as an error. This will help to see what it
             // is like when an assertion fails.
            //we can take this further by printing out the title and location and compare what
             // it sees and what I expect:
        //Assert.assertTrue("The page title is" + title + "and the location title is" + location, title.contains(location));
    }

    public ProductDetailPage clickOnTheFirstResult()
    {
        results.get(0).click();// this will click the 1st product (index 0)
        return  new ProductDetailPage(driver);
    }


    public ProductDetailPage clickOnAnyResult()
    {
        int noOfElements = results.size(); // this will get the no of results on the page
        Random random = new Random();
        int ranNumber = random.nextInt(noOfElements -1);


        results.get(ranNumber).click();// this will click the 1st product (index 0)
        return  new ProductDetailPage(driver);
    }
}
