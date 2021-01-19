package co.uk.zoopla.hooks;

import co.uk.zoopla.commons.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BrowserManager
{
    @Before
    public void setup()
    {
        launchBrowser("Chrome");
    }
    @After
    public void teardown()

    {
        closeBrowser();
    }
}
