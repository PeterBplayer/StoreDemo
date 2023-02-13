package pl.soflab.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.soflab.pages.HomePage;

public class SendMessageTest extends BaseTest {

    @Test
    public void sendingMessage() {
        WebElement message = new HomePage(driver)
                .fillUpContactForm("Test", "test@mail.com", "Test massage")
                .getConfirmation();

        Assert.assertEquals(message.getText(), "It is demo page! We are not sending emails!");
    }

}
