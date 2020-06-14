import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.springframework.core.annotation.Order;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TS01_Museums extends Page {

    String homePageXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView";

    public void navigateToMuseumsTab() {
        launchApp();
        //click mall tab
        clickTabItem(1);

    }

    // Test Application Open and show home screen
    @Test(testName = "TC01.01 : Verify If Application Launches")
    public void applicationIsOpen() {
        launchApp();
        String tabTitle = driver.findElement(By.xpath(homePageXpath)).getText();
        assertEquals("Riyadh Tour", tabTitle);
    }

    @Test(testName = "TC01.02 : Verify If All Museums Are Displayed")
    public void isMuseumsTabDisplayed() {
        navigateToMuseumsTab();
        assertTrue(isTabSelected(1));
    }

    @Test(testName = "TC01.03 : Verify If All Museums Switch to GMAPS When Clicked")
    public void isSuccessfullyRedirectedToGoogleMaps() {
        int listSize = 5;
        for (int i = 1; i <= listSize; i++) {
            navigateToMuseumsTab();
            clickListItem(i);
            //is google map open
            implicitlyWait(3);
            assertEquals(isCurrentActivity(), googleMapActivity);
        }
    }

    @Test(testName = "TC01.04 : Verify If Location of The First Museum Is Correct")
    public void isFirstMuseumLocationCorrect() {
        navigateToMuseumsTab();
        //click first museum
        clickListItem(1);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "King Abdulaziz Historical Center (National Museum)");
    }

    @Test(testName = "TC01.05 : Verify If Location of The Second Museum Is Correct")
    public void isSecondMuseumLocationCorrect() {
        navigateToMuseumsTab();
        //click second museum
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "Saqr Aljazeera Aviation Museum");
    }

    @Test(testName = "TC01.06 : Verify If Location of The Third Museum Is Correct")
    public void isThirdMuseumLocationCorrect() {
        navigateToMuseumsTab();
        //click third museum
        clickListItem(3);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "Al Masmak Palace Museum");
    }

    @Test(testName = "TC01.07 : Verify If Location of The Fourth Museum Is Correct")
    public void isFourthMuseumLocationCorrect() {
        navigateToMuseumsTab();
        //click forth museum
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "Murabba Historical Palace");
    }

    @Test(testName = "TC01.08 : Verify If Location of The Fifth Museum Is Correct")
    public void isFifthMuseumLocationCorrect() {
        navigateToMuseumsTab();
        //click fifth museum
        clickListItem(5);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "King Salman Science Oasis Taawun");
    }

    @Test(testName = "TC01.09 : Verify If The Working Hours of The First Museum Is Correct")
    public void isFirstMuseumWorkingHoursCorrect() {
        navigateToMuseumsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(1, 2), "Working Hours: 8AM-9PM");
    }

    @Test(testName = "TC01.10 : Verify If The Working Hours of The Second Museum Is Correct")
    public void isSecondMuseumWorkingHoursCorrect() {
        navigateToMuseumsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(2, 2), "Working Hours: 8AM-8PM");
    }

    @Test(testName = "TC01.11 : Verify If The Working Hours of The Third Museum Is Correct")
    public void isThirdMuseumWorkingHoursCorrect() {
        navigateToMuseumsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(3, 2), "Working Hours: 8AM-9PM");
    }

    @Test(testName = "TC01.12 : Verify If The Working Hours of The Fourth Museum Is Correct")
    public void isFourthMuseumWorkingHoursCorrect() {
//        test = extent.createTest("Check if The Working hours of The Fourth Museum Is Correct");
        navigateToMuseumsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(4, 2), "Working Hours: 8AM-9PM");
    }

    @Test(testName = "TC01.13 : Verify If The Working Hours of The Fifth Museum Is Correct")
    public void isFifthMuseumWorkingHoursCorrect() {
        navigateToMuseumsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(5, 2), "Working Hours: 8AM-8PM");
    }

    @Test(testName = "TC01.14 : Verify If All Museums Images Are Displayed")
    public void areAllImagesDisplayed() {
        navigateToMuseumsTab();
        // are all 5 images displayed
        assertTrue(isImageDisplayed(1));
        assertTrue(isImageDisplayed(2));
        assertTrue(isImageDisplayed(3));
        assertTrue(isImageDisplayed(4));
        assertTrue(isImageDisplayed(5));
    }


}
