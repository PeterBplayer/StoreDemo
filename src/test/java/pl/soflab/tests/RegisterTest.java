package pl.soflab.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.soflab.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {

        int randomNumber = (int) (Math.random() * 1000);

        WebElement dashboardLink =
                new HomePage(driver)
                        .openMyAccountPage()
                        .registerUserValidData("test" + randomNumber + "@test.pl", "test@test.pl123")
                        .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {

        WebElement error =
                new HomePage(driver)
                        .openMyAccountPage()
                        .registerUserInvalidData("test@test.pl", "test@test.pl13")
                        .getError();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address."));
    }
}
