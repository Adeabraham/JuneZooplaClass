package co.uk.zoopla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends BasePage
{
    //creating a constructor:
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //telling selenium how to find the element
    @FindBy(id = "search-input-location") //use this id to find an element for me. Its ID on HTML
    private WebElement searchField;      // is search-input-location and it is stored privately in
                                         //this class. It is a WebElement which I give the name
                                        //searchField

    //we have created an element searchField above.
    //now we need to create a method that will interact
    //with the element: i.e 1

    @FindBy(css=".ui-button-primary.ui-cookie-accept-all-medium-large")
    private WebElement acceptCookieButton; // go to 2
    @FindBy(name="price_min")
    private WebElement minPrice;
    @FindBy(name="price_max")
    private WebElement maxPrice;
    @FindBy(id="property_type")
    private WebElement propertyType;
    @FindBy(id="beds_min")
    private WebElement noOfBeds;
    @FindBy(id = "search-submit")
    private WebElement submitButton;
   // @FindBy(css = "[href='/to-rent/']")
   // private WebElement forRent;
   @FindBy(css = "#search-tabs-to-rent")
   private WebElement forRent;
   @FindBy(id = "rent_price_min_per_month")
   private WebElement minRentPrice;
   @FindBy(id = "rent_price_max_per_month")
   private WebElement maxRentPrice;


    public void enterLocationValue(String location) // 1
    {
        searchField.sendKeys(location);
        searchField.click();
    }

    public void clickOnCookieButton() // 2
    {
        acceptCookieButton.click();
    }

    public void selectMinimumPrice(String minimumPrice)
    {
        selectByText(minPrice, minimumPrice);// minPrice is the element we defined by ourselves,
                                             // that is what selenium will find and from the element, it
                                             //will select whatever we pass into minimumPrice
    }

    public void selectMaximumPrice(String maximumPrice)
    {
        selectByText(maxPrice, maximumPrice);
    }

    public void selectPropertyType(String property)
    {
        selectByText(propertyType, property);
    }

    public void selectNoOfBeds(String beds)
    {
        selectByText(noOfBeds, beds);
    }

     public SearchResultPage clickOnSubmitButton() // Because am expecting a new page back (SearchResultPage),
                                                 // I need to specify the new page am expecting
     {
         submitButton.click(); //this action is performed on the current page
         return new SearchResultPage(driver);//action performed on the new page: without this line of code it
                                              //wont be able to interact with the new/next page
         // now we need to introduce the 2nd/new page at step definition:
         //i.e. SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
     }

    public ErrorPage clickOnSubmitButtonForError() // Because am expecting a new page back (ErrorPage),
    // I need to specify the new page am expecting
    {
        submitButton.click(); //this action is performed on the current page
        return new ErrorPage(driver);//action performed on the new page: without this line of code it
        //wont be able to interact with the new/next page
        // now we need to introduce the 2nd/new page at step definition:
        //i.e. ErrorPage errorPage = PageFactory.initElements(driver, ErrorPage.class);
    }

    public void clickToRent()
    {
        forRent.click();
    }

    public void selectMinRentPrice(String minimumRentPrice)
    {
        selectByText(minRentPrice, minimumRentPrice);
    }

    public void selectMaxRentPrice(String maximumRentPrice)
    {
        selectByText(maxRentPrice, maximumRentPrice);
    }
}
