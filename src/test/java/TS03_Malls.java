import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TS03_Malls extends Page {


    public void navigateToMallsTab()
    {
        launchApp();
        //click mall tab
        clickTabItem(3);

    }
    @Test(testName = "TC03.01 : Verify If All Malls Are Displayed")
    public void isMallsTabDisplayed() {
        navigateToMallsTab();
        assertTrue(isTabSelected(3));
    }

    @Test(testName = "TC03.02 : Verify If All Malls Switch to GMAPS When Clicked")
    public void isSuccessfullyRedirectedToGoogleMaps() {
        int listSize = 5;
        for (int i = 1; i <= listSize; i++) {
            navigateToMallsTab();
            clickListItem(i);
            //is google map open
            implicitlyWait(3);
            assertEquals(isCurrentActivity(),googleMapActivity);
        }
    }


    @Test(testName = "TC03.03 : Verify If Location of The First Mall Is Correct")
    public void isFirstMallLocationCorrect() {
        navigateToMallsTab();
        //click first mall
        clickListItem(1);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"Al Nakheel Mall by Arabian Centres النخيل مول من المراكز العربية");
    }

    @Test(testName = "TC03.04 : Verify If Location of The Second Mall Is Correct")
    public void isSecondMallLocationCorrect() {
        navigateToMallsTab();
        //click second mall
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"Centria Mall");
    }

    @Test(testName = "TC03.05 : Verify If Location of The Third Mall Is Correct")
    public void isThirdMallLocationCorrect() {
        navigateToMallsTab();
        //click third mall
        clickListItem(3);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(),"Riyadh Gallery Mall");
    }

    @Test(testName = "TC03.06 : Verify If Location of The Fourth Mall Is Correct")
    public void isFourthMallLocationCorrect() {
        navigateToMallsTab();
        //click forth mall
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"Hayat Mall");
    }

    @Test(testName = "TC03.07 : Verify If Location of The Fifth Mall Is Correct")
    public void isFifthMallLocationCorrect() {
        navigateToMallsTab();
        //click fifth mall
        clickListItem(5);
        implicitlyWait(5);
        // is location correct
        assertEquals(isLocationCorrect(),"غرناطة مول Granada Mall");
    }

    @Test(testName = "TC03.08 : Verify If The Working hours of The First Mall Is Correct")
    public void isFirstMallWorkingHoursCorrect() {
        navigateToMallsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(1, 2),"Working Hours: 9:30AM-11PM");
    }

    @Test(testName = "TC03.09 : Verify If The Working hours of The Second Mall Is Correct")
    public void isSecondMallWorkingHoursCorrect() {
        navigateToMallsTab();
        isMallsTabDisplayed();
        // is working hours correct
        assertEquals(getCurrentItemText(2, 2),"Working Hours: 10AM-10:30PM");
    }

    @Test(testName = "TC03.10 : Verify If The Working hours of The Third Mall Is Correct")
    public void isThirdMallWorkingHoursCorrect() {
        navigateToMallsTab();
        isMallsTabDisplayed();
        // is working hours correct
        assertEquals(getCurrentItemText(3, 2),"Working Hours: 8AM-12AM");
    }

    @Test(testName = "TC03.11: Verify If The Working hours of The Fourth Mall Is Correct")
    public void isFourthMallWorkingHoursCorrect() {
        navigateToMallsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(4, 2),"Working Hours: 8AM-1AM");
    }

    @Test(testName = "TC03.12 : Verify If The Working hours of The Fifth Mall Is Correct")
    public void isFifthMallWorkingHoursCorrect() {
        navigateToMallsTab();
        // is working hours correct
        assertEquals( getCurrentItemText(5, 2),"Working Hours: 9AM-11PM");
    }

    @Test(testName = "TC03.13 : Verify If All Malls Images Are Displayed")
    public void areAllImagesDisplayed() {
        navigateToMallsTab();
        // are all 5 images displayed
        assertTrue(isImageDisplayed(1));
        assertTrue(isImageDisplayed(2));
        assertTrue(isImageDisplayed(3));
        assertTrue(isImageDisplayed(4));
        assertTrue(isImageDisplayed(5));
    }


}
