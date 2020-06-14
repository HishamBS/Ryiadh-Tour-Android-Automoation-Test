import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Page {

    protected AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private String gmapsTitleId = "com.google.android.apps.maps:id/title";
    String googleMapActivity = "com.google.android.maps.MapsActivity";
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;


    //configuring extent report
    @BeforeTest
    public void configureExtent() {
        // specify location of the report
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Extent-Automation-Report.html");
        htmlReporter.config().setDocumentTitle("Riyadh Tour Automation Report"); // Tile of report
        htmlReporter.config().setReportName("Functional Testing"); // Name of the report
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // Passing General information
        extent.setSystemInfo("Host name", "Appium");
        extent.setSystemInfo("Platform", "Android Virtual");
        extent.setSystemInfo("Tester", "Hisham");
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }


    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        dc.setCapability(MobileCapabilityType.VERSION, "10.0");
//        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.riyadhtour");
//        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);

        test = extent.createTest(this.getClass().getName());
//            driver.startActivity(new Activity("com.example.android.riyadhtour",".MainActivity"));


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


//    @BeforeMethod
//    public void setup(Method method) {
//        String testMethodName = method.getName(); //This will be:verifySaveButtonEnabled
//        String descriptiveTestName = method.getAnnotation(Test.class).testName(); //This will be: 'Verify if the save button is enabled'
////        test = extent.createTest(descriptiveTestName);
//        test.createNode(descriptiveTestName);
//
//
//    }

    @AfterMethod
    public void updateReport(ITestResult result, Method method) throws IOException {
        String descriptiveTestName = method.getAnnotation(Test.class).testName();
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = getScreenshot(driver, result.getName());
            test.createNode(descriptiveTestName)
                    .log(Status.FAIL, "❌FAILED TEST CASE => " + result.getName()) // to add name in extent report
                    .log(Status.ERROR, "⛔️ERROR RECIEVED => " + result.getThrowable())// to add error/exception in extent report
                    .fail("<b><font color=red>"
                            + " Click the below link OR check the report folder by above screenshot Name to get the Screenshot of failure "
                            + "</font></b>", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.createNode(descriptiveTestName).log(Status.SKIP, "SKIPED TEST CASE => " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.createNode(descriptiveTestName).log(Status.PASS, "✅PASSED TEST CASE => " + result.getName());
        }

//        driver.quit();


    }


    public void launchApp() {
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


    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/test-output/extent-screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        String relative = "./extent-screenshots/" + screenshotName + dateName + ".png";

        return relative;
    }

//

}

