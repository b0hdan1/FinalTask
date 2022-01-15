package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='myAccountDropdown']")
    WebElement accountDropdown;

    @FindBy(xpath = "//a[contains(text(), 'Join')]")
    WebElement joinButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign In')]")
    WebElement signInButton;
    @FindBy(xpath = "//input[@id='chrome-search']")
    WebElement searchField;

    @FindBy(xpath = "//button[@class='kH5PAAC _1KRfEms']")
    WebElement searchButton;

    @FindBy(xpath = "//span[@class='tiqiyps']")
    WebElement hiMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isVisibleAccountDropdown() {
        return accountDropdown.isDisplayed();
    }

    public void clickMyAccountDropdown() {
        accountDropdown.click();
        waitVisibilityOfElement(DEFAULT_TIMEOUT, joinButton);
    }

    public void clickJoinButton() {
        joinButton.click();
    }

    public boolean checkGreeting() {
        waitVisibilityOfElement(DEFAULT_TIMEOUT, hiMessage);
        return hiMessage.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void searchByWord(String searchWord) {
        searchField.sendKeys(searchWord);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
