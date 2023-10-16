import com.automationbymounika.components.DataProviderArgs;
import com.automationbymounika.components.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demoTest {
    @DataProviderArgs("demoTest=username,password")
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = "jsonDataProvider")
    public void demoTest(String username, String password) {
        System.out.println("username and password are: " + username + "," + password);
    }
}
