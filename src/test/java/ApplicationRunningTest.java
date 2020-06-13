
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ApplicationRunningTest extends Page
{
    String homePageXpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView";
    // Test Application Open and show home screen
    @Test
    public void applicationIsOpen() {
        launchApp();
        String tabTitle = driver.findElement(By.xpath(homePageXpath)).getText();
        assertEquals("Riyadh Tour",tabTitle);
    }
}
