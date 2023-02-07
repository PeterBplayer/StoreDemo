package pl.soflab.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.soflab.models.Customer;
import pl.soflab.pages.HomePage;
import pl.soflab.pages.OrderDetailsPage;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage =
                new HomePage(driver)
                        .openShopPage()
                        .openProduct("Java Selenium WebDriver")
                        .addProductToCart()
                        .viewCart()
                        .openAddressDetails()
                        .fillOrderForm(customer, "test comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver × 1");
    }
}
