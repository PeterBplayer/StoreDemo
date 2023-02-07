package pl.soflab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;
    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;
    @FindBy(id = "billing_company")
    private WebElement companyNameInput;
    @FindBy(id = "select2-billing_country-container")
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
    private WebElement placeOrderInput;


    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
