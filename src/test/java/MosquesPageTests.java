
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MosquesPageTests extends Page {
    String googleMapActivity = "com.google.android.maps.MapsActivity";

    @Test
    public void isMosqueTabDisplayed() {
        launchApp();
        //click mosque tab
        clickTabItem(2);
        assertTrue(isTabSelected(2));
        assertEquals("King Khalid Grand Mosque", getCurrentItemText(1, 1));
    }

    @Test
    public void isSuccessfullyRedirectedToGoogleMaps() {
        isMosqueTabDisplayed();
        //click first mosque
        clickListItem(1);
        //is google map open
        assertEquals(googleMapActivity, isCurrentActivity());
    }

    @Test
    public void isFirstMosqueLocationCorrect() {
        isMosqueTabDisplayed();
        //click first mosque
        clickListItem(1);
        implicitlyWait(3);
        // is location correct
        assertEquals("Umm Al Hamam St", isLocationCorrect());

    }

    @Test
    public void isSecondMosqueLocationCorrect() {
        isMosqueTabDisplayed();
        //click second mosque
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals("7084 Al Akheyar, Al Jazirah", isLocationCorrect());

    }

    @Test
    public void isThirdMosqueLocationCorrect() {
        isMosqueTabDisplayed();
        //click third mosque
        clickListItem(3);
        implicitlyWait(3);
        // is location correct
        assertEquals("King Abdullah Branch Rd", isLocationCorrect());

    }

    @Test
    public void isFourthMosqueLocationCorrect() {
        isMosqueTabDisplayed();
        //click forth mosque
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals("Princess Latifa Bint Sultan Bin Abdulaziz Grand Mosque", isLocationCorrect());

    }

    @Test
    public void isFifthMosqueLocationCorrect() {
        isMosqueTabDisplayed();
        //click fifth mosque
        clickListItem(5);
        implicitlyWait(3);
        // is location correct
        assertEquals("7110 Uthman Ibn Affan Branch Rd, Al Izdihar", isLocationCorrect());
    }

    @Test
    public void isFirstMosqueWorkingHoursCorrect() {
        isMosqueTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: Always Open", getCurrentItemText(1, 2));
    }

    @Test
    public void isSecondMosqueWorkingHoursCorrect() {
        isMosqueTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: Always Open", getCurrentItemText(2, 2));
    }

    @Test
    public void isThirdMosqueWorkingHoursCorrect() {
        isMosqueTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: Always Open", getCurrentItemText(3, 2));
    }

    @Test
    public void isFourthMosqueWorkingHoursCorrect() {
        isMosqueTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: Always Open", getCurrentItemText(4, 2));
    }

    @Test
    public void isFifthMosqueWorkingHoursCorrect() {
        isMosqueTabDisplayed();
        // is working hours correct
        assertEquals("Working Hours: Always Open", getCurrentItemText(5, 2));
    }


}
