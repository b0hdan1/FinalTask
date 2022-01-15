package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedProductPage extends BasePage{
    public SelectedProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Add to bag')]")
    WebElement addToBagButton;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    WebElement errorMessage;

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    WebElement sizeSelectButton;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    WebElement bagItems;

    public boolean isAddToBagButtonVisible() {
        return addToBagButton.isDisplayed();
    }

    public void clickAddToBagButton() {
        addToBagButton.click();
    }

    public String checkErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isSizeSelectButtonVisible() {
        waitVisibilityOfElement(DEFAULT_TIMEOUT, sizeSelectButton);
        return sizeSelectButton.isDisplayed();
    }

    public void clickSizeButton() {
        sizeSelectButton.click();
    }

    public void clickOnFirstSizeButton(){
        sizeSelectButton.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public boolean checkProductInTheBag(final String countOfItems) {
        waitVisibilityOfElement(DEFAULT_TIMEOUT, bagItems);
        final int bagItemsCount = Integer.parseInt(bagItems.getText());
        return bagItemsCount == Integer.parseInt(countOfItems);
    }
}
