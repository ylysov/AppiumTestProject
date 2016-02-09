package WebDriver.WrappedDriver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup  {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException, IOException {

        ProcessBuilder pb = new ProcessBuilder("C:/Program Files (x86)/Android/android-sdk/AVD Manager.exe");
        pb.directory(new File("C:/Program Files (x86)/Android/android-sdk/"));
        Process p = pb.start();


        //execute script

        String Dir = "C:/Program Files (x86)/Android/android-sdk/tools/";
        String Command = "emulator -avd Phone4.4.2";
        Process pp =Runtime.getRuntime().exec(Dir + Command);


        //Starts Appium server
        AppiumDriverLocalService  service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("c:/Program Files/nodejs/node.exe") )
                .withAppiumJS(new File ("c:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js")));


        service.start();



        // Defining Capabilities and starting virtual device
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

    protected static void startAppium() {
       AppiumDriverLocalService  service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                                           .usingDriverExecutable(new File("c:/Program Files/nodejs/node.exe") )
                                           .withAppiumJS(new File ("c:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js")));

    }



}

//"http://127.0.0.1:4723/wd/hub"   =  ConfigProvider.getHubURL()