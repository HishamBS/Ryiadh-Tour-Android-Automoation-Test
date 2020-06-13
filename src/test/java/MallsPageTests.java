import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MallsPageTests extends Page {


    @Test
    public void isMallsTabDisplayed() {
        launchApp();
        //click mall tab
        clickTabItem(3);
        assertTrue(isTabSelected(3));
        assertEquals("Al Nakheel Mall", getCurrentItemText(1, 1));
    }

    @Test
    public void isSuccessfullyRedirectedToGoogleMaps() {

        isMallsTabDisplayed();
        //click first mall
        clickListItem(1);
        //is google map open
        assertEquals(googleMapActivity, isCurrentActivity());
    }

    @Test
    public void isFirstMallLocationCorrect() {
        isMallsTabDisplayed();
        //click first mall
        clickListItem(1);
        implicitlyWait(3);
        clickTabItem("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
        // is location correct
        implicitlyWait(7);
        assertEquals("Al Nakheel Mall", isLocationCorrect());

    }

    @Test
    public void isSecondMallLocationCorrect() {
        isMallsTabDisplayed();
        //click second mall
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals("Olaya St", isLocationCorrect());

    }

    @Test
    public void isThirdMallLocationCorrect() {
        isMallsTabDisplayed();
        //click third mall
        clickListItem(3);
        implicitlyWait(3);
        // is location correct
        assertEquals("King Fahd Rd", isLocationCorrect());

    }

    @Test
    public void isFourthMallLocationCorrect() {
        isMallsTabDisplayed();
        //click forth mall
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals("King Abdul Aziz Rd", isLocationCorrect());

    }

    @Test
    public void isFifthMallLocationCorrect() {
        isMallsTabDisplayed();
        //click fifth mall
        clickListItem(5);
        implicitlyWait(5);
        clickTabItem("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]");
        implicitlyWait(7);
        // is location correct
        String fifthMall = getTextByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ViewSwitcher/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView");
        assertEquals("غرناطة مول Granada Mall", fifthMall);
    }

    @Test
    public void isFirstMallWorkingHoursCorrect() {
        isMallsTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: 9:30AM-11PM", getCurrentItemText(1, 2));
    }

    @Test
    public void isSecondMallWorkingHoursCorrect() {
        isMallsTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: 10AM-10:30PM", getCurrentItemText(2, 2));
    }

    @Test
    public void isThirdMallWorkingHoursCorrect() {
        isMallsTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: 8AM-12AM", getCurrentItemText(3, 2));
    }

    @Test
    public void isFourthMallWorkingHoursCorrect() {
        isMallsTabDisplayed();        //click first museum
        // is working hours correct
        assertEquals("Working Hours: 8AM-1AM", getCurrentItemText(4, 2));
    }

    @Test
    public void isFifthMallWorkingHoursCorrect() {
        isMallsTabDisplayed();        //click first museum
        // is working hours correct
        assertEquals("Working Hours: 9AM-11PM", getCurrentItemText(5, 2));
    }

    @Test
    public void areAllImagesDisplayed() {
        isMallsTabDisplayed();
        // are all 5 images displayed
        assertTrue(isImageDisplayed(1));
        assertTrue(isImageDisplayed(2));
        assertTrue(isImageDisplayed(3));
        assertTrue(isImageDisplayed(4));
        assertTrue(isImageDisplayed(5));


    }


}
