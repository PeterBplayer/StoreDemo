package pl.soflab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.soflab.models.Customer;
import pl.soflab.utils.SeleniumHelper;

import java.time.Duration;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;
    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;
    @FindBy(id = "billing_company")
    private WebElement companyNameInput;
    @FindBy(id = "billing_country")
    private WebElement billingCountrySelect;
    @FindBy(id = "billing_address_1")
    private WebElement billingAddressInput;
    @FindBy(id = "billing_address_2")
    private WebElement billingAddressSecondInput;
    @FindBy(id = "billing_postcode")
    private WebElement billingPostcodeInput;
    @FindBy(id = "billing_city")
    private WebElement billingCityInput;
    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;
    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;
    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;
    @FindBy(id = "place_order")
    private WebElement placeOrderButton;


    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillOrderForm(Customer customer, String comments) {
        firstNameInput.sendKeys(customer.getFistName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(billingCountrySelect);
        countrySelect.selectByVisibleText(customer.getCountry());
        billingAddressInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostcodeInput.sendKeys(customer.getZipCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        orderCommentsInput.sendKeys(comments);

        SeleniumHelper.waitForBeLocated(By.id("place_order"), driver);
        SeleniumHelper.waitForClickable(placeOrderButton, driver);


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(By.id("place_order")));

        placeOrderButton.click();

        return new OrderDetailsPage(driver);
    }
}
