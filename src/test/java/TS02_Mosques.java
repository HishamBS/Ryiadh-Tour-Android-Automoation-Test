
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TS02_Mosques extends Page {


    public void navigateToMosquesTab() {
        launchApp();
        //click mall tab
        clickTabItem(2);

    }

    @Test(testName = "TC02.01 : Verify If All Mosques Are Displayed")
    public void isMosqueTabDisplayed() {
        navigateToMosquesTab();
        assertTrue(isTabSelected(2));
    }

    @Test(testName = "TC02.02 : Verify If All Mosques Switch to GMAPS When Clicked")
    public void isSuccessfullyRedirectedToGoogleMaps() {
        int listSize = 5;
        for (int i = 1; i <= listSize; i++) {
            navigateToMosquesTab();
            clickListItem(i);
            //is google map open
            implicitlyWait(3);
            assertEquals(isCurrentActivity(), googleMapActivity);
        }
    }

    @Test(testName = "TC02.03 : Verify If Location of The First Mosque Is Correct")
    public void isFirstMosqueLocationCorrect() {
        navigateToMosquesTab();
        //click first mosque
        clickListItem(1);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "King Khalid Grand Mosque");
    }

    @Test(testName = "TC02.04 : Verify If Location of The Second Mosque Is Correct")
    public void isSecondMosqueLocationCorrect() {
        navigateToMosquesTab();
        //click second mosque
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "Al Rajhi Mosque");
    }

    @Test(testName = "TC02.05 : Verify If Location of The Third Mosque Is Correct")
    public void isThirdMosqueLocationCorrect() {
        navigateToMosquesTab();
        clickListItem(3);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "Fahad Al Owaidah Grand Mosque");
    }

    @Test(testName = "TC02.06 : Verify If Location of The Fourth Mosque Is Correct")
    public void isFourthMosqueLocationCorrect() {
        navigateToMosquesTab();
        //click forth mosque
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "Princess Latifa Bint Sultan Bin Abdulaziz Grand Mosque");
    }

    @Test(testName = "TC02.07 : Verify If Location of The Fifth Mosque Is Correct")
    public void isFifthMosqueLocationCorrect() {
        navigateToMosquesTab();
        //click fifth mosque
        clickListItem(5);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(), "Al Jowharah Grand Mosque");
    }

    @Test(testName = "TC02.08 : Verify If The Working hours of The First Mosque Is Correct")
    public void isFirstMosqueWorkingHoursCorrect() {
        navigateToMosquesTab();
        // is working hours correct
        assertEquals(getCurrentItemText(1, 2), "Working Hours: Always Open");
    }

    @Test(testName = "TC02.09 : Verify If The Working hours of The Second Mosque Is Correct")
    public void isSecondMosqueWorkingHoursCorrect() {
        navigateToMosquesTab();
        // is working hours correct
        assertEquals(getCurrentItemText(2, 2), "Working Hours: Always Open");
    }

    @Test(testName = "TC02.10 : Verify If The Working hours of The Third Mosque Is Correct")
    public void isThirdMosqueWorkingHoursCorrect() {
        navigateToMosquesTab();
        // is working hours correct
        assertEquals(getCurrentItemText(3, 2), "Working Hours: Always Open");
    }

    @Test(testName = "TC02.11 : Verify If The Working hours of The Fourth Mosque Is Correct")
    public void isFourthMosqueWorkingHoursCorrect() {
        navigateToMosquesTab();
        // is working hours correct
        assertEquals(getCurrentItemText(4, 2), "Working Hours: Always Open");
    }

    @Test(testName = "TC02.12 : Verify If The Working hours of The Fifth Mosque Is Correct")
    public void isFifthMosqueWorkingHoursCorrect() {
        navigateToMosquesTab();
        // is working hours correct
        assertEquals(getCurrentItemText(5, 2), "Working Hours: Always Open");
    }


}
