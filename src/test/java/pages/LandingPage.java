package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends PageBase {

    String newstring = "lalala";

    String emailButtonId = "am.sunrise.android.calendar:id/button_connect_with_email";

    String emailButtonxpath = "//*[@bounds='[404,972][644,1076]']";

    String facebookButtonId = "am.sunrise.android.calendar:id/button_connect_with_facebook";
    String googlePlusButtonId = "am.sunrise.android.calendar:id/button_connect_with_google_plus";

    String backPlusButtonId = "android:id/up";

    public LandingPage(WebDriver driver) {super(driver); }

    public LandingPage clickConnectWithEmail() {
//        driver.findElement(By.xpath(emailButtonxpath)).click();
        driver.findElement(By.id(emailButtonId)).click();
        return new LandingPage(driver);
    }

    public LandingPage clickConnectWithFacebook() {
        driver.findElement(By.xpath(facebookButtonId)).click();
        return new LandingPage(driver);
    }

    public LandingPage clickConnectGoogle() {
        driver.findElement(By.xpath(googlePlusButtonId)).click();

        return new LandingPage(driver);
    }

    public LandingPage clickBackButton() {
        driver.findElement(By.id(backPlusButtonId)).click();
        return new LandingPage(driver);
    }
}