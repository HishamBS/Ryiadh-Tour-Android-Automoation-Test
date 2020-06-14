
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MosquesPageTests extends Page {


    public void navigateToMosquesTab()
    {
        launchApp();
        //click mall tab
        clickTabItem(2);

    }
    @Test
    public void isMosqueTabDisplayed() {
        test = extent.createTest("Check if All Mosques List is Displayed");

        navigateToMosquesTab();
        assertTrue(isTabSelected(2));

    }

    @Test
    public void isSuccessfullyRedirectedToGoogleMaps() {
        test = extent.createTest("Check if every Mosque switch To GMAPS when Clicked");

        int listSize = 5;
        for (int i = 1; i <= listSize; i++) {
            navigateToMosquesTab();
            clickListItem(i);
            //is google map open
            assertEquals(isCurrentActivity(),googleMapActivity);
        }

    }

    @Test
    public void isFirstMosqueLocationCorrect() {
        test = extent.createTest("Check if Location of The First Mosque Is Correct");

        navigateToMosquesTab();
        //click first mosque
        clickListItem(1);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"Umm Al Hamam St");


    }

    @Test
    public void isSecondMosqueLocationCorrect() {
        test = extent.createTest("Check if Location of The Second Mosque Is Correct");

        navigateToMosquesTab();
        //click second mosque
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"7084 Al Akheyar, Al Jazirah");


    }

    @Test
    public void isThirdMosqueLocationCorrect() {
        test = extent.createTest("Check if Location of The Third Mosque Is Correct");

        navigateToMosquesTab();
        clickListItem(3);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"King Abdullah Branch Rd");


    }

    @Test
    public void isFourthMosqueLocationCorrect() {
        test = extent.createTest("Check if Location of The Fourth Mosque Is Correct");

        navigateToMosquesTab();
        //click forth mosque
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"Princess Latifa Bint Sultan Bin Abdulaziz Grand Mosque");

    }

    @Test
    public void isFifthMosqueLocationCorrect() {
        test = extent.createTest("Check if Location of The Fifth Mosque Is Correct");

        navigateToMosquesTab();

        //click fifth mosque
        clickListItem(5);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(),"7110 Uthman Ibn Affan Branch Rd, Al Izdihar");

    }

    @Test
    public void isFirstMosqueWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The First Mosque Is Correct");

        navigateToMosquesTab();
        // is working hours correct
        assertEquals( getCurrentItemText(1, 2),"Working Hours: Always Open");

    }

    @Test
    public void isSecondMosqueWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Second Mosque Is Correct");

        navigateToMosquesTab();
        // is working hours correct
        assertEquals( getCurrentItemText(2, 2),"Working Hours: Always Open");

    }

    @Test
    public void isThirdMosqueWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Third Mosque Is Correct");

        navigateToMosquesTab();
        // is working hours correct
        assertEquals( getCurrentItemText(3, 2),"Working Hours: Always Open");

    }

    @Test
    public void isFourthMosqueWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Fourth Mosque Is Correct");

        navigateToMosquesTab();
        // is working hours correct
        assertEquals(getCurrentItemText(4, 2),"Working Hours: Always Open");

    }

    @Test
    public void isFifthMosqueWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Fifth Mosque Is Correct");

        navigateToMosquesTab();
        // is working hours correct
        assertEquals( getCurrentItemText(5, 2),"Working Hours: Always Open");

    }


}
