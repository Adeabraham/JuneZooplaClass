package co.uk.zoopla.pages;

import co.uk.zoopla.commons.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends DriverManager
{
   public String Base_URl = "https://www.zoopla.co.uk/";//  1
   public Select select;  //  4
   public void launchURL()   // 2
   {
       driver.navigate().to(Base_URl);  //  3
   }

   public void selectByText(WebElement element, String text)  //  5
   {
       select = new Select(element);  //  6
       select.selectByVisibleText(text);
       // to tell selenium that whatever is selected is what is displayed: i.e. to verify:
       Assert.assertTrue(select.getFirstSelectedOption().getText().equals(text)); // get the ist thing we ask u to select,
                                                                                 // get the text that is attached to it and make
                                                                                  // sure it is equal to what we ask u to select

       // the code below can be used personally for troubleshooting to
       // display what is selected. It should not be checked into github with the rest of the code (unprofessional!)
       //System.out.println(select.getFirstSelectedOption().getText());
   }

   public void selectByValue(WebElement element, String value)
   {
       select = new Select(element);
       select.selectByValue(value);
   }
   public void selectByIndex(WebElement element, int index)
   {
       select = new Select(element);
       select.selectByIndex(index);
   }

}
