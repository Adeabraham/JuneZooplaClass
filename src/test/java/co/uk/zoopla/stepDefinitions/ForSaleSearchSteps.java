package co.uk.zoopla.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ForSaleSearchSteps {

    WebDriver driver;

    @Given("I navigate to Zoopla homepage")
    public void i_navigate_to_zoopla_homepage() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.iedriver().setup();

        // launch a browser
         driver = new ChromeDriver();
        //driver = new FirefoxDriver();

        //driver = new InternetExplorerDriver();

        //enters the url and
        // navigate to the url
        driver.navigate().to("https://www.zoopla.co.uk/");



    }

    @When("I enter {string} into the search field")
    public void i_enter_into_the_search_field(String location) {
        driver.findElement(By.id("search-input-location")).sendKeys(location);

    }

    @When("I select {string} from Min price")
    public void i_select_from_min_price(String string) {

    }

    @When("I select {string} from Max price")
    public void i_select_from_max_price(String string) {

    }

    @When("I select {string} from Property type")
    public void i_select_from_property_type(String string) {

    }

    @When("I select {string} from Bedrooms")
    public void i_select_from_bedrooms(String string) {

    }

    @When("I click on Search button")
    public void i_click_on_search_button() {

    }

    @Then("the search for {string} is displayed")
    public void the_search_for_is_displayed(String string) {

    }
    @Then("an error page is displayed")
    public void an_error_page_is_displayed() {

    }
}
