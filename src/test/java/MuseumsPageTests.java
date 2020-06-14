import com.aventstack.extentreports.ExtentTest;
import org.springframework.core.annotation.Order;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MuseumsPageTests extends Page {


    public void navigateToMuseumsTab()
    {
        launchApp();
        //click mall tab
        clickTabItem(1);

    }

    @Test
    public void isMuseumsTabDisplayed() {
        test = extent.createTest("Check if All Museums List is Displayed");

        navigateToMuseumsTab();
        assertTrue(isTabSelected(1));

    }

    @Test
    public void isSuccessfullyRedirectedToGoogleMaps() {
        test = extent.createTest("Check if every Museum  switch To GMAPS when Clicked");

        int listSize = 5;
        for (int i = 1; i <= listSize; i++) {
            navigateToMuseumsTab();
            clickListItem(i);
            //is google map open
            assertEquals(isCurrentActivity(),googleMapActivity);
        }

    }

    @Test
    public void isFirstMuseumLocationCorrect() {
        test = extent.createTest("Check if Location of The First Museum Is Correct");

        navigateToMuseumsTab();
        //click first museum
        clickListItem(1);
        implicitlyWait(3);
        // is location correct
        assertEquals(isLocationCorrect(),"King Faisal Road");


    }

    @Test
    public void isSecondMuseumLocationCorrect() {
        test = extent.createTest("Check if Location of The Second Museum Is Correct");

        navigateToMuseumsTab();
        //click second museum
        clickListItem(2);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"Saqr Aljazeera Aviation Museum");


    }

    @Test
    public void isThirdMuseumLocationCorrect() {
        test = extent.createTest("Check if Location of The Third Museum Is Correct");

        navigateToMuseumsTab();
        //click third museum
        clickListItem(3);
        implicitlyWait(3);
        //click partial
        clickTabItem("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout");
//        click("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ViewSwitcher/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]");
        // is location correct
        implicitlyWait(7);
        assertEquals( isLocationCorrect(),"Al Masmak Palace Museum");

    }

    @Test
    public void isFourthMuseumLocationCorrect() {
        test = extent.createTest("Check if Location of The Fourth Museum Is Correct");

        navigateToMuseumsTab();

        //click forth museum
        clickListItem(4);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"2722 الملك سعود، Al Murabba");

    }

    @Test
    public void isFifthMuseumLocationCorrect() {
        test = extent.createTest("Check if Location of The Fifth Museum Is Correct");

        navigateToMuseumsTab();
        //click fifth museum
        clickListItem(5);
        implicitlyWait(3);
        // is location correct
        assertEquals( isLocationCorrect(),"King Salman Science Oasis");

    }

    @Test
    public void isFirstMuseumWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The First Museum Is Correct");

        navigateToMuseumsTab();

        // is working hours correct
        assertEquals( getCurrentItemText(1, 2),"Working Hours: 8AM-9PM");

    }

    @Test
    public void isSecondMuseumWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Second Museum Is Correct");
        navigateToMuseumsTab();
        // is working hours correct
        assertEquals( getCurrentItemText(2, 2),"Working Hours: 8AM-8PM");

    }

    @Test
    public void isThirdMuseumWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Third Museum Is Correct");
        navigateToMuseumsTab();

        // is working hours correct
        assertEquals( getCurrentItemText(3, 2),"Working Hours: 8AM-9PM");

    }

    @Test
    public void isFourthMuseumWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Fourth Museum Is Correct");
        navigateToMuseumsTab();
        // is working hours correct
        assertEquals( getCurrentItemText(4, 2),"Working Hours: 8AM-9PM");

    }

    @Test
    public void isFifthMuseumWorkingHoursCorrect() {
        test = extent.createTest("Check if The Working hours of The Fifth Museum Is Correct");
        navigateToMuseumsTab();
        // is working hours correct
        assertEquals( getCurrentItemText(5, 2),"Working Hours: 8AM-8PM");

    }

    @Test
    public void areAllImagesDisplayed() {
        test = extent.createTest("Check if All Museums Images Are Displayed");

        navigateToMuseumsTab();
        // are all 5 images displayed
        assertTrue(isImageDisplayed(1));
        assertTrue(isImageDisplayed(2));
        assertTrue(isImageDisplayed(3));
        assertTrue(isImageDisplayed(4));
        assertTrue(isImageDisplayed(5));

    }


}
