package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;
    RegistrationPage registrationPage;
    SearchingPage searchingPage;
    SelectedProductPage selectedProductPage;
    FilterSettingsPage filterSettingsPage;
    SignInPage signInPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks registration button visibility")
    public void userChecksRegistrationButtonVisibility() {
        assertTrue(homePage.isVisibleAccountDropdown());
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User clicks Join button")
    public void clickJoinButton() {
        homePage.clickMyAccountDropdown();
        homePage.clickJoinButton();
    }

    @When("User fills in all required registration fields with {string}")
    public void fillsAllRequiredRegistrationFields(final String name) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.fillFieldsWithCorrectValues(name);
    }

    @When("User fills in all required registration fields with invalid {string}")
    public void fillsInAllRequiredRegistrationFieldsWithWrongEmail(final String email) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.fillFieldsWithInCorrectValues(email);
    }

    @When("User fills in required registration fields with invalid {string}")
    public void userFillsInRequiredRegistrationFieldsWithInvalidPassword(final String password) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.fillFieldsWithInCorrectPassword(password);
    }


    @And("User clicks registration button")
    public void clickJoinAsosButton() {
        registrationPage.clickRegisterButton();
    }

    @And("User clicks account dropdown")
    public void clickAccountDropdown() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickMyAccountDropdown();
    }

    @Then("User sees their greeting")
    public void userSeesTheirGreeting() {
        assertTrue(homePage.checkGreeting());
    }

    @Then("User sees email error")
    public void userSeesError() {
        assertTrue(registrationPage.isEmailWrong());
    }

    @And("User checks search field visibility")
    public void checksSearchFieldVisibility() {
        assertTrue(homePage.isSearchFieldVisible());
    }

    @When("User makes search by keyword {string}")
    public void makesSearchByKeywordSearchWord(final String searchWord) {
         homePage.searchByWord(searchWord);
    }

    @And("User clicks search button")
    public void clicksSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that current url contains {string}")
    public void checksThatCurrentUrlContainsCurrentUrl(final String currentUrl) {
        assertTrue(driver.getCurrentUrl().contains(currentUrl));
    }

    @And("User check 'Email address' field is visible")
    public void isEmailAddressFieldIsVisible() {
        registrationPage = pageFactoryManager.getRegistrationPage();
        assertTrue(registrationPage.isEmailFieldVisible());
    }

    @And("User check 'First name' field is visible")
    public void isFirstNameFieldIsVisible() {
        assertTrue(registrationPage.isFirstNameFieldVisible());
    }

    @And("User check 'Last name' field is visible")
    public void checkLastNameFieldIsVisible() {
        assertTrue(registrationPage.isLastNameFieldVisible());
    }

    @And("User check 'Password' field is visible")
    public void checkPasswordFieldIsVisible() {
        assertTrue(registrationPage.isPasswordFieldVisible());
    }

    @And("User check 'Day of birth' field is visible")
    public void isDayOfBirthFieldsIsVisible() {
        assertTrue(registrationPage.isDayOfBirthFieldVisible());
    }

    @And("User check 'Month of birth' field is visible")
    public void isMonthOfBirthFieldsIsVisible() {
        assertTrue(registrationPage.isMonthOfBirthFieldVisible());
    }

    @And("User check 'Year of birth' field is visible")
    public void isDayOfYearFieldsIsVisible() {
        assertTrue(registrationPage.isYearOfBirthFieldVisible());
    }

    @And("User clicks on first product")
    public void clicksOnFirstProduct() {
        searchingPage = pageFactoryManager.getSearchingPage();
        searchingPage.getFirstProduct();
    }

    @And("User checks 'ADD TO BAG' button visibility")
    public void userChecksAddToBagButtonVisibility() {
        selectedProductPage = pageFactoryManager.getSelectedProductPage();
        assertTrue(selectedProductPage.isAddToBagButtonVisible());
    }

    @And("User clicks 'ADD TO BAG' button on product")
    public void clicksAddToBagButton() {
        selectedProductPage.clickAddToBagButton();
        selectedProductPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @Then("User will see the {string}")
    public void userWillSeeTheMessage(final String message) {
        assertTrue(selectedProductPage.checkErrorMessage().contains(message));
    }


    @Then("User check {string} items on the page")
    public void checkCurrentCountItemsOnThePage(final String currentCount) {
        searchingPage = pageFactoryManager.getSearchingPage();
        assertTrue(searchingPage.getAmountOfProducts(Integer.parseInt(currentCount)));
    }

    @And("User checks size button visibility")
    public void checksSizeButtonVisibility() {
        selectedProductPage = pageFactoryManager.getSelectedProductPage();
        assertTrue(selectedProductPage.isSizeSelectButtonVisible());
    }

    @And("User select size button")
    public void selectSizeOfProduct() {
        selectedProductPage.clickSizeButton();
    }

    @And("User clicks on first size field")
    public void userClicksOnFirstSizeField() {
        selectedProductPage.clickOnFirstSizeButton();
    }

    @Then("User check {string} item\\(s) in the bag")
    public void checkCountOfItemsItemsInTheBag(final String countOfItems) {
        assertTrue(selectedProductPage.checkProductInTheBag(countOfItems));
    }

    @And("User click 'Add to wishlist' on first product")
    public void clickAddToWishlistButton() {
        searchingPage = pageFactoryManager.getSearchingPage();
        searchingPage.clickAddProductToWish();
    }

    @Then("User makes sure that {string} products are added to the wishlist")
    public void userMakesSureThatCountOfItemsProductsAreAddedToTheWishlist(final String countOfItems) {
        assertEquals(Integer.parseInt(countOfItems), searchingPage.getAmountOfProductsInWishList());
    }

    @And("User check visible filter button")
    public void userCheckVisibleFilterButton() {
        filterSettingsPage = pageFactoryManager.getFilterSettingsPage();
        filterSettingsPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        assertTrue(filterSettingsPage.isVisibleFilterButton());
    }

    @And("User clicks 'Brand' filter button")
    public void clickLeatherNonLeatherFilterField() {
        filterSettingsPage.clickFilterByLeatherButton();
    }

    @And("User select 'ASOS'")
    public void selectFilterWord() {
        filterSettingsPage.clickSelectAsos();
        filterSettingsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User sees password error")
    public void userSeesPasswordError() {
        assertTrue(registrationPage.isPasswordWrong());
    }


    @And("User click 'Sign In' button")
    public void clickSignInButton() {
        homePage.clickMyAccountDropdown();
        homePage.clickSignInButton();
    }

    @And("User check 'Sign In Email address' field is visible")
    public void userCheckSignInEmailAddressFieldIsVisible() {
        signInPage = pageFactoryManager.getSignInPage();
        assertTrue(signInPage.isSignInEmailFieldVisible());
    }

    @And("User enter {string}")
    public void userEnterEmail(final String email) {
        signInPage.enterSignInEmail(email);
    }

    @And("User check 'Sign In Password' field is visible")
    public void userCheckSignInPasswordFieldIsVisible() {
        assertTrue(signInPage.isPasswordFieldVisible());
    }

    @And("User enter {string} to 'Sign In' field")
    public void enterPasswordToSignInField(final String password) {
        signInPage.enterSignInPassword(password);
    }

    @And("User click 'Sign In' button in Sign In page")
    public void clickSignInButtonInSignInPage() {
        signInPage.clickSignInButton();
    }
}
