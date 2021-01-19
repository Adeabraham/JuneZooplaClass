package co.uk.zoopla.stepDefinitions;

import co.uk.zoopla.pages.BasePage;
import co.uk.zoopla.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class ForRentSearchSteps extends BasePage

{
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @Given("i click on for rent tab")
    public void i_click_on_for_rent_tab() {
        homePage.clickToRent();

    }

    @When("I select {string} from Min rent price")
    public void i_select_from_min_rent_price(String miniRentPrice) {
        homePage.selectMinRentPrice(miniRentPrice);
    }

    @When("I select {string} from Max rent price")
    public void i_select_from_max_rent_price(String maxRentPrice) {
        homePage.selectMaxRentPrice(maxRentPrice);
    }


}
