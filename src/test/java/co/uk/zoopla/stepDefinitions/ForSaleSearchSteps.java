package co.uk.zoopla.stepDefinitions;

import co.uk.zoopla.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;


public class ForSaleSearchSteps extends BasePage {

     HomePage homePage = PageFactory.initElements(driver, HomePage.class);// instantiation of HomePage, using PageFactory, instead of new, to initialise driver and HomePage
     //above means: selenium, use pageFactory library to initialise driver (i.e. connected to the browser)
    // and homepage (whatever is inside HomePage to be stored in homePage) for me.
    SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    ProductDetailPage productDetailPage = PageFactory.initElements(driver, ProductDetailPage.class);
    ErrorPage errorPage = PageFactory.initElements(driver, ErrorPage.class);




    @Given("I navigate to Zoopla homepage")
    public void i_navigate_to_zoopla_homepage() {
        homePage.launchURL();
        // or simply write: launchURL(); //because the class has already inherited BasePage.
        homePage.clickOnCookieButton();

    }

    @When("I enter {string} into the search field")
    public void i_enter_into_the_search_field(String location) {
        homePage.enterLocationValue(location);

    }

    @When("I select {string} from Min price")
    public void i_select_from_min_price(String miniPrice) {
       homePage.selectMinimumPrice(miniPrice);//the value of miniPrice is been fed
                                              // from the scenario outline table
    }

    @When("I select {string} from Max price")
    public void i_select_from_max_price(String maxiPrice) {
        homePage.selectMaximumPrice(maxiPrice);

    }

    @When("I select {string} from Property type")
    public void i_select_from_property_type(String typeOfProperty) {
        homePage.selectPropertyType(typeOfProperty);

    }

    @When("I select {string} from Bedrooms")
    public void i_select_from_bedrooms(String bedNo) {
        homePage.selectNoOfBeds(bedNo);

    }

    @When("I click on Search button")
    public void i_click_on_search_button() {
       searchResultPage = homePage.clickOnSubmitButton();
    }

    @Then("the search for {string} is displayed")
    public void the_search_for_is_displayed(String location) {
        searchResultPage.isSearchResultPageDisplayed(location);
        // this will get the Url and verify that the location
        // (e.g. London) is inside of the Url in order to confirm we're on searchResultPage

        searchResultPage.doesPageTitleContain(location);
        // the above verifies there is location inside of the pageTitle
    }
    @Then("an error page is displayed")
    public void an_error_page_is_displayed() {



    }

    @Then("I click on one of the search results")
    public void i_click_on_one_of_the_search_results() {
      //productDetailPage = searchResultPage.clickOnTheFirstResult();
      productDetailPage = searchResultPage.clickOnAnyResult();
    }

    @When("I click on Search button to expect error")
    public void i_click_on_search_button_to_expect_error() {
        errorPage = homePage.clickOnSubmitButtonForError();

    }

}
