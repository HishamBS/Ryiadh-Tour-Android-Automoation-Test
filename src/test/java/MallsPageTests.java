import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MallsPageTests extends Page {


    public void navigateToMallsTab()
    {
        launchApp();
        //click mall tab
        clickTabItem(3);

    }
    @Test
    public void isMallsTabDisplayed() {
        test = extent.createTest("Check if All Malls List is Displayed");
        navigateToMallsTab();
        assertTrue(isTabSelected(3));
    }

    @Test
    public void isSuccessfullyRedirectedToGoogleMaps() {
        test = extent.createTest("Check if every Mall switch To GMAPS when Clicked");
        int listSize = 5;
        for (int i = 1; i <= listSize; i++) {
            navigateToMallsTab();
            clickListItem(i);
            //is google map open
            assertEquals(isCurrentActivity(),googleMapActivity);
        }

    }


    @Test
    public void isFirstMallLocationCorrect() {
        test = extent.createTest("Check if Location of The First Mall Is Correct");

        navigateToMallsTab();
        //click first mall
        clickListItem(1);
        implicitlyWait(3);
        clickTabItem("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
        // is location correct
        implicitlyWait(7);
        assertEquals( isLocationCorrect(),"Al Nakheel Mall");

    }

    @Test
    public void isSecondMallLocationCorrect() {
        test = extent.createTest("Check if Location of The Second Mall Is Correct");

        navigateToMallsTab();
        //click second mall
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"Olaya St");

    }

    @Test
    public void isThirdMallLocationCorrect() {
        test = extent.createTest("Check if Location of The Third Mall Is Correct");

        navigateToMallsTab();
        //click third mall
        clickListItem(3);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(),"King Fahd Rd");

    }

    @Test
    public void isFourthMallLocationCorrect() {
        test = extent.createTest("Check if Location of The Fourth Mall Is Correct");

        navigateToMallsTab();
        //click forth mall
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"King Abdul Aziz Rd");

    }

    @Test
    public void isFifthMallLocationCorrect() {
        test = extent.createTest("Check if Location of The Fifth Mall Is Correct");

        navigateToMallsTab();
        //click fifth mall
        clickListItem(5);
        implicitlyWait(5);
        clickTabItem("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]");
        implicitlyWait(7);
        // is location correct
        String fifthMall = getTextByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ViewSwitcher/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView");
        assertEquals(fifthMall,"غرناطة مول Granada Mall");
    }

    @Test
    public void isFirstMallWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The First Mall Is Correct");

        navigateToMallsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(1, 2),"Working Hours: 9:30AM-11PM");
    }

    @Test
    public void isSecondMallWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Second Mall Is Correct");

        navigateToMallsTab();
        isMallsTabDisplayed();
        // is working hours correct
        assertEquals(getCurrentItemText(2, 2),"Working Hours: 10AM-10:30PM");
    }

    @Test
    public void isThirdMallWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Third Mall Is Correct");

        navigateToMallsTab();
        isMallsTabDisplayed();
        // is working hours correct
        assertEquals(getCurrentItemText(3, 2),"Working Hours: 8AM-12AM");
    }

    @Test
    public void isFourthMallWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Fourth Mall Is Correct");
        navigateToMallsTab();
        // is working hours correct
        assertEquals(getCurrentItemText(4, 2),"Working Hours: 8AM-1AM");
    }

    @Test
    public void isFifthMallWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Fifth Mall Is Correct");

        navigateToMallsTab();
        // is working hours correct
        assertEquals( getCurrentItemText(5, 2),"Working Hours: 9AM-11PM");
    }

    @Test
    public void areAllImagesDisplayed() {
        test = extent.createTest("Check if All Malls Images Are Displayed");

        navigateToMallsTab();
        // are all 5 images displayed
        assertTrue(isImageDisplayed(1));
        assertTrue(isImageDisplayed(2));
        assertTrue(isImageDisplayed(3));
        assertTrue(isImageDisplayed(4));
        assertTrue(isImageDisplayed(5));


    }


}
