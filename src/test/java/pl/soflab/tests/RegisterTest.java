package pl.soflab.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.soflab.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {

        int randomNumber = (int) (Math.random() * 1000);

        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .registerUser("test" + randomNumber + "@test.pl", "test@test.pl123")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }
}
