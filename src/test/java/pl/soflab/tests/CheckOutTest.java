package pl.soflab.tests;

import org.testng.annotations.Test;
import pl.soflab.models.Customer;
import pl.soflab.pages.HomePage;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();
        customer.setFistName("Bu");
        customer.setLastName("Kropel");
        customer.setCompanyName("TestCompany");
        customer.setCountry("Poland");
        customer.setStreet("Testowa");
        customer.setFlatNumber("666");
        customer.setZipCode("52-745");
        customer.setCity("Warszawa/Warsaw");
        customer.setPhone("123456789");
        customer.setEmail("test@test.com");


        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillOrderForm(customer,"test comment");
    }
}
