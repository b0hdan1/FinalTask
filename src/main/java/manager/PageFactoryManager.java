package manager;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public RegistrationPage getRegistrationPage() {
        return new RegistrationPage(driver);
    }

    public SearchingPage getSearchingPage() {
        return new SearchingPage(driver);
    }

    public SelectedProductPage getSelectedProductPage() {
        return new SelectedProductPage(driver);
    }

    public FilterSettingsPage getFilterSettingsPage() {
        return new FilterSettingsPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }
}
