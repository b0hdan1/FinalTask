package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchingPage extends BasePage {
    public SearchingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//article[@class='_2qG85dG']")
    List<WebElement> listOfProducts;

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    List<WebElement> addToWishlistButton;

    @FindBy(xpath = "//button[@aria-label='Item saved']")
    List<WebElement> wishListButtonClicked;

    public void getFirstProduct() {
        listOfProducts.get(0).click();
    }

    public List<WebElement> getListOfProducts() {
        waitForPageLoadComplete(DEFAULT_TIMEOUT);
        return listOfProducts;
    }

    public boolean getAmountOfProducts(int amountProducts) {
        return getListOfProducts().size() == amountProducts;
    }

    public void clickAddProductToWish() {
        waitVisibilityOfElement(DEFAULT_TIMEOUT, addToWishlistButton.get(0));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToWishlistButton.get(0)).click().build().perform();
    }

    public List<WebElement> getWishList() {
        return wishListButtonClicked;
    }

    public int getAmountOfProductsInWishList() {
        return getWishList().size();
    }
}
