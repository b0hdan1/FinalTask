package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//select[@id='BirthDay']")
    WebElement dayBirthday;

    @FindBy(xpath = "//select[@id='BirthMonth']")
    WebElement monthBirthday;

    @FindBy(xpath = "//select[@id='BirthYear']")
    WebElement yearBirthday;

    @FindBy(xpath = "//div[@class='submit']//input[@id='register']")
    WebElement registerButton;

    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement invalidEmail;

    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement invalidPassword;

    public void fillFieldsWithCorrectValues(String name) {
        emailField.sendKeys("lagep549223222@rubygon.com");
        firstNameField.sendKeys(name);
        lastNameField.sendKeys("SomeLastName");
        password.sendKeys("Random_Password");
        dayBirthday.click();
        dayBirthday.sendKeys(Keys.ARROW_DOWN);
        monthBirthday.click();
        monthBirthday.sendKeys(Keys.ARROW_DOWN);
        yearBirthday.click();
        yearBirthday.sendKeys(Keys.ARROW_DOWN);
    }

    public void fillFieldsWithInCorrectValues(String email) {
        emailField.sendKeys(email);
        firstNameField.sendKeys("SomeName");
        lastNameField.sendKeys("SomeLastName");
        password.sendKeys("Random_Password");
        dayBirthday.click();
        dayBirthday.sendKeys(Keys.ARROW_DOWN);
        monthBirthday.click();
        monthBirthday.sendKeys(Keys.ARROW_DOWN);
        yearBirthday.click();
        yearBirthday.sendKeys(Keys.ARROW_DOWN);
        yearBirthday.sendKeys(Keys.ENTER);
    }

    public void fillFieldsWithInCorrectPassword(String invalidPassword) {
        emailField.sendKeys("theBestEmail@gmail.com");
        firstNameField.sendKeys("SomeName");
        lastNameField.sendKeys("SomeLastName");
        password.sendKeys(invalidPassword);
        dayBirthday.click();
        dayBirthday.sendKeys(Keys.ARROW_DOWN);
        monthBirthday.click();
        monthBirthday.sendKeys(Keys.ARROW_DOWN);
        yearBirthday.click();
        yearBirthday.sendKeys(Keys.ARROW_DOWN);
        yearBirthday.sendKeys(Keys.ENTER);
    }

    public void clickRegisterButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(registerButton).build().perform();
        registerButton.click();
    }

    public boolean isEmailWrong() {
        return invalidEmail.isDisplayed();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isFirstNameFieldVisible() {
        return firstNameField.isDisplayed();
    }

    public boolean isLastNameFieldVisible() {
        return lastNameField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return password.isDisplayed();
    }

    public boolean isDayOfBirthFieldVisible() {
        return dayBirthday.isDisplayed();
    }

    public boolean isMonthOfBirthFieldVisible() {
        return monthBirthday.isDisplayed();
    }

    public boolean isYearOfBirthFieldVisible() {
        return yearBirthday.isDisplayed();
    }

    public boolean isPasswordWrong() {
        return invalidPassword.isDisplayed();
    }
}
