package WebDriver.WrappedDriver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class IOSSetup {
    protected IOSDriver driver;
    //private WebDriver driver;

    protected void prepareIOSAppium() throws MalformedURLException {

        //Appium needs the path of app build
        //Set up the desired capabilities and pass the iOS SDK version and app path to Appium
        File app = new File("/Users/upgundecha/Desktop/AppExamples/BmiCalculator/build/Release-iphonesimulator/BmiCalculator.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability(CapabilityType.VERSION, "6.1");
        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
        capabilities.setCapability("app", app.getAbsolutePath());

        //Create an instance of RemoteWebDriver and connect to the Appium server.
        //Appium will launch the BmiCalc App in iPhone Simulator using the configurations specified in Desired Capabilities



        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new IOSDriver(new URL(ConfigProvider.getHubURL()), capabilities);
    }
}

//"http://127.0.0.1:4723/wd/hub"   =  ConfigProvider.getHubURL()
// driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

    //File app = new File(ConfigProvider.getAppsDirectoryPath(), ConfigProvider.getAppFile());

    //DesiredCapabilities capabilities = new DesiredCapabilities();
//capabilities.setCapability("device","Android");

        //mandatory capabilities
        //capabilities.setCapability("deviceName","Android");
        //capabilities.setCapability("platformName","Android");