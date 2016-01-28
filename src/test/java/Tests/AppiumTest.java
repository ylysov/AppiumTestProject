package Tests;

import WebDriver.WrappedDriver.AndroidSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;


public class AppiumTest extends AndroidSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void connectWithEmail()
    {
        new LandingPage(driver).clickConnectWithEmail();
    }


    @Test
    public void returnBack()    { new LandingPage(driver).clickBackButton(); }

}

