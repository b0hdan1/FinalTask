package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='EmailAddress']")
    WebElement signInEmailField;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//div[@class='submit']")
    WebElement signInButton;

    public boolean isSignInEmailFieldVisible() {
        return signInEmailField.isDisplayed();
    }

    public void enterSignInEmail(final String email) {
        signInEmailField.sendKeys(email);
    }

    public boolean isPasswordFieldVisible() {
        return password.isDisplayed();
    }

    public void enterSignInPassword(final String SignInPassword) {
        password.sendKeys(SignInPassword);
    }

    public void clickSignInButton() {
        signInButton.click();
        waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }
}
