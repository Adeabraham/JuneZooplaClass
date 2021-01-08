package co.uk.zoopla.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class BrowserManager extends DriverManager
{
   private WebDriver initChrome()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private WebDriver initHeadlessChrome()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "-headless"); //disable anything that shows
                                                            // and run it headlessly and drop
                                                            // the options right here:
        return new ChromeDriver(options);
    }

    private WebDriver initFirefox()
    {
        WebDriverManager.firefoxdriver().setup();
        return new ChromeDriver();
    }
    private WebDriver initHeadlessFirefox()
    {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-gpu", "-headless"); //disable anything that shows
                                                            // and run it headlessly and drop
                                                            // the options right here:
        return new FirefoxDriver(options);
    }
    public void launchBrowser(String browser)
    {
        switch(browser)
        {
            case "Chrome":
                driver = initChrome();
                break;
            case "HeadlessChrome":
                driver = initHeadlessChrome();
                break;
            case "Firefox":
                driver = initFirefox();
                break;
            case "HeadlessFirefox":
                driver = initHeadlessFirefox();
                break;
            default:
                driver = initHeadlessChrome();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // wait for 10s if you can't find the element on the page
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //wait for 30s for the page to load
    }
       public void closeBrowser()
       {
           driver.manage().deleteAllCookies(); // so that each test run can be unique
           driver.quit();
       }

}
