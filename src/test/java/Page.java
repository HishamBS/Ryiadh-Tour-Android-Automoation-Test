import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Page {

    protected AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private String gmapsTitleId = "com.google.android.apps.maps:id/title";
    String googleMapActivity = "com.google.android.maps.MapsActivity";



    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        dc.setCapability(MobileCapabilityType.VERSION, "10.0");
//        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.riyadhtour");
//        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);

//            driver.startActivity(new Activity("com.example.android.riyadhtour",".MainActivity"));
        new WebDriverWait(driver, 10);


    }


    public void launchApp(){
        driver.startActivity(new Activity("com.example.android.riyadhtour", ".MainActivity"));
    }
    public void implicitlyWait(int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public String getTextByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();

    }

    public String getCurrentItemText(int relativeLayout, int textView) {
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ListView/android.widget.RelativeLayout[" + relativeLayout + "]/android.widget.LinearLayout/android.widget.TextView[" + textView + "]")).getText();
    }

    public boolean isImageDisplayed(int position) {
        return driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Location Image\"])[" + position + "]")).isDisplayed();
    }

    public boolean isTabSelected(int position) {
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[" + position + "]/android.widget.TextView")).isSelected();
    }

    public void clickListItem(int position) {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ListView/android.widget.RelativeLayout[" + position + "]/android.widget.LinearLayout/android.widget.TextView[1]")).click();
    }

    public void clickTabItem(int position) {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[" + position + "]/android.widget.TextView")).click();
    }

    public void clickTabItem(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public String isCurrentActivity() {
        return driver.currentActivity();
    }

    public String isLocationCorrect() {
        return driver.findElement(By.id(gmapsTitleId)).getText();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

