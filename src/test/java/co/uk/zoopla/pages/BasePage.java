package co.uk.zoopla.pages;

import co.uk.zoopla.commons.DriverManager;
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
   }

   public void selectByValue(WebElement element, String value)
   {
       select = new Select(element);
       select.selectByVisibleText(value);
   }
   public void selectByIndex(WebElement element, int index)
   {
       select = new Select(element);
       select.selectByIndex(index);
   }

}
