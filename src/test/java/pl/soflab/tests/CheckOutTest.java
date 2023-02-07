package pl.soflab.tests;

import org.testng.annotations.Test;
import pl.soflab.models.Customer;
import pl.soflab.pages.HomePage;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();
        customer.setFistName("Bob");
        customer.setLastName("Artua");
        customer.setCompanyName("TestPip");
        customer.setCountry("Peru");
        customer.setStreet("Little");
        customer.setFlatNumber("656");
        customer.setZipCode("8-5651");
        customer.setCity("Lima");
        customer.setPhone("111222333");
        customer.setEmail("test1@test.com");


        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillOrderForm(customer,"test comment");
    }
}
