package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterSettingsPage extends BasePage{
    public FilterSettingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@data-dropdown-id='brand']")
    WebElement filterByAsosButton;

    @FindBy(xpath = "//label[@class='_3FDbbAD _1ikeRVG']")
    WebElement selectAsos;

    public boolean isVisibleFilterButton() {
        return filterByAsosButton.isDisplayed();
    }

    public void clickFilterByLeatherButton() {
        filterByAsosButton.click();
    }

    public void clickSelectAsos() {
        waitVisibilityOfElement(DEFAULT_TIMEOUT, selectAsos);
        selectAsos.click();
    }

}
