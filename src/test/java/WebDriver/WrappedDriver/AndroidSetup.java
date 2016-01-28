package WebDriver.WrappedDriver;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {

        File app = new File(ConfigProvider.getAppsDirectoryPath(), ConfigProvider.getAppFile());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL(ConfigProvider.getHubURL()), capabilities);
    }
}

//"http://127.0.0.1:4723/wd/hub"   =  ConfigProvider.getHubURL()