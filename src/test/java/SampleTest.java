import com.automationbymounika.browser.DriverManager;
import com.automationbymounika.components.ElementFindBy;
import com.automationbymounika.properties.PropertiesLoader;
import com.automationbymounika.properties.PropertiesValidator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void testSampleTest() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        DriverManager driverManager = new DriverManager();
        driverManager.loadDriver();
        Thread.sleep(2000);
        driverManager.driver.get("https://www.google.com/");
        Thread.sleep(3000);
        ElementFindBy findBy = new ElementFindBy(DriverManager.driver);
        Thread.sleep(5000);
        WebElement element = findBy.findElementBy("GooglePage.tbx_Search");
        Thread.sleep(3000);
        element.sendKeys("Testing Framework");
        Thread.sleep(4000);
        driverManager.closeBrowser();
    }
}
