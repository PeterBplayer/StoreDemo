package pl.soflab.tests;

import org.testng.annotations.Test;
import pl.soflab.pages.HomePage;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails();
    }
}
