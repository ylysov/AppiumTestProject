package WebDriver.WrappedDriver;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class ConfigProvider {

    static File configFile;
    static Properties properties;
    static FileInputStream inputStream;

    private static Properties ConfigurationParameters() throws IOException {
        configFile = new File("TestConfiguration.properties");
        properties = new Properties();
        inputStream = new FileInputStream(configFile);
        properties.load(inputStream);

        return properties;
    }


    private static String getSolutionFolderPath() {
        String folderPath = System.getProperty("user.dir");
        return folderPath;
    }

    public static String getAppsDirectoryPath() {
        String appDir = getSolutionFolderPath() + "\\apps\\";
        return appDir;
    }

    public static String getAppFile() {
        try {
            return ConfigurationParameters().getProperty("appFile");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getHubURL() {
        try {
            return ConfigurationParameters().getProperty("HubURL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}




   /* public static String getValidUserName() {
        try {
            return ConfigurationParameters().getProperty("userName");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static long getPageLoadTimeout(){
        try{
            long pageLoadTimeout = Long.parseLong(ConfigurationParameters().getProperty("pageLoadTimeout"));
            return pageLoadTimeout;
    }
        catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static long getThreadSleepTimeout(){
        try{
            long pageLoadTimeout = Long.parseLong(ConfigurationParameters().getProperty("threadSleepTimeout"));
            return pageLoadTimeout;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static URL getBaseURL() {
        try {
            URL url = new URL (ConfigurationParameters().getProperty("130_VirtualMachineURL"));
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/




