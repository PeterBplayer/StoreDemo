package pl.soflab.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.soflab.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        WebElement entryTitle = new HomePage(driver).openMyAccountPage()
                .registerUser("test2@test.pl", "test@test.pl123")
                .getEntryTitle();

        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertEquals(entryTitle.getText(), "My account");
    }
}
