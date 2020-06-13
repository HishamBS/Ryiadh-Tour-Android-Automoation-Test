import org.springframework.core.annotation.Order;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MuseumsPageTests extends Page {
    String googleMapActivity = "com.google.android.maps.MapsActivity";


    @Test
    public void isMuseumsTabDisplayed() {
        launchApp();
        //click museum tab
        clickTabItem(1);
        assertTrue(isTabSelected(1));
        assertEquals("King Abdulaziz Historical Center", getCurrentItemText(1, 1));
    }

    @Test
    public void isSuccessfullyRedirectedToGoogleMaps() {
        isMuseumsTabDisplayed();
        //click first museum
        clickListItem(1);
        //is google map open
        assertEquals(googleMapActivity, isCurrentActivity());
    }

    @Test
    public void isFirstMuseumLocationCorrect() {
        isMuseumsTabDisplayed();
        //click first museum
        clickListItem(1);
        implicitlyWait(3);
        // is location correct
        assertEquals("King Faisal Road", isLocationCorrect());

    }

    @Test
    public void isSecondMuseumLocationCorrect() {
        isMuseumsTabDisplayed();
        //click second museum
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals("Saqr Aljazeera Aviation Museum", isLocationCorrect());

    }

    @Test
    public void isThirdMuseumLocationCorrect() {
        isMuseumsTabDisplayed();
        //click third museum
        clickListItem(3);
        implicitlyWait(3);
        //click partial
        clickTabItem("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout");
//        click("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ViewSwitcher/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]");
        // is location correct
        implicitlyWait(7);
        assertEquals("Al Masmak Palace Museum", isLocationCorrect());

    }

    @Test
    public void isFourthMuseumLocationCorrect() {
        isMuseumsTabDisplayed();
        //click forth museum
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals("2722 الملك سعود، Al Murabba", isLocationCorrect());

    }

    @Test
    public void isFifthMuseumLocationCorrect() {
        isMuseumsTabDisplayed();
        //click fifth museum
        clickListItem(5);
        implicitlyWait(3);
        // is location correct
        assertEquals("King Salman Science Oasis", isLocationCorrect());
    }

    @Test
    public void isFirstMuseumWorkingHoursCorrect() {
        isMuseumsTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: 8AM-9PM", getCurrentItemText(1, 2));
    }

    @Test
    public void isSecondMuseumWorkingHoursCorrect() {
        isMuseumsTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: 8AM-8PM", getCurrentItemText(2, 2));
    }

    @Test
    public void isThirdMuseumWorkingHoursCorrect() {
        isMuseumsTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: 8AM-9PM", getCurrentItemText(3, 2));
    }

    @Test
    public void isFourthMuseumWorkingHoursCorrect() {
        isMuseumsTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: 8AM-9PM", getCurrentItemText(4, 2));
    }

    @Test
    public void isFifthMuseumWorkingHoursCorrect() {
        isMuseumsTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: 8AM-8PM", getCurrentItemText(5, 2));
    }

    @Test
    public void areAllImagesDisplayed() {
        isMuseumsTabDisplayed();
        // are all 5 images displayed
        assertTrue(isImageDisplayed(1));
        assertTrue(isImageDisplayed(2));
        assertTrue(isImageDisplayed(3));
        assertTrue(isImageDisplayed(4));
        assertTrue(isImageDisplayed(5));

    }


}
