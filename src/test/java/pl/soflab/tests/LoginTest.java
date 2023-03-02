package pl.soflab.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.soflab.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidDataTest() {

        WebElement dashboardLink =
                new HomePage(driver)
                        .openMyAccountPage()
                        .logInValidData("test@test.com", "test@test.pl123")
                        .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void loginWithInvalidPasswordTest() {

        WebElement error =
                new HomePage(driver)
                        .openMyAccountPage()
                        .logInInvalidData("invalidtest@test.pl", "test@testpl")
                        .getError();

        Assert.assertTrue(error.getText().contains("Incorrect username or password."), "Expected error text does not match");
    }
}
