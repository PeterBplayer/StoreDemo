package pl.soflab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.soflab.utils.SeleniumHelper;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;
    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;
    @FindBy(xpath = "//button[@name='register']")
    private WebElement registerButton;
    @FindBy(id = "username")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(name = "login")
    private WebElement loginButton;
    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        SeleniumHelper.waitForBeLocated(By.xpath("//button[@name='register']"), driver);
        SeleniumHelper.waitForClickable(registerButton, driver);
        registerButton.click();
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);
        return this;
    }

    private void logIn(String email, String password) {
        userNameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public LoggedUserPage logInValidData(String email, String password) {
        logIn(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInvalidData(String email, String password) {
        logIn(email, password);
        return this;
    }

    public WebElement getError() {
        return error;
    }
}
