package pl.soflab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.soflab.utils.SeleniumHelper;

public class HomePage {

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;
    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;
    @FindBy(name = "nimble_name")
    private WebElement titleInput;
    @FindBy(name = "nimble_email")
    private WebElement emailInput;
    @FindBy(name = "nimble_message")
    private WebElement massageInput;
    @FindBy(name = "nimble_submit")
    private WebElement submitButton;
    @FindBy(css = "span[class='sek-form-message']")
    private WebElement confirmation;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver);
    }

    public ProductListPage openShopPage() {
        shopLink.click();
        return new ProductListPage(driver);
    }

    public HomePage fillUpContactForm(String subject, String email, String msgString) {
        titleInput.sendKeys(subject);
        emailInput.sendKeys(email);
        massageInput.sendKeys(msgString);
        submitButton.click();
        return this;
    }

    public WebElement getConfirmation() {
        SeleniumHelper.waitForBeVisible(confirmation, driver);
        return confirmation;
    }
}
