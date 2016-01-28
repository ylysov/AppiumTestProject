package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * Created by ylysov on 21.01.2016.
 */
public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }
}
