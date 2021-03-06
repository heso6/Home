package pages.myStore;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Page;

import java.util.List;

public class MainPage extends Page {
    private static String URL = "http://automationpractice.com/";

    @Override
    public void open() {
        driver.get(URL);
    }

    @FindBy(xpath = "//div[@class='header_user_info']")
    private WebElement signInButton;

    @FindBy(xpath = "(//a[@title=\"Faded Short Sleeve T-shirts\"])[2]")
    private WebElement fadedShortSleeveTshirts;

    @FindBy(xpath = "(//a[@title=\"Blouse\"])[2]")
    private WebElement blouse;

    @FindBy(xpath = "(//a[@title=\"Printed Dress\"])[2]")
    private WebElement printedDress;

    @FindBy(id = "add_to_cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@title=\"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//span[@class=\"cross\"]")
    private WebElement crossButton;

    @FindBy(id = "header_logo")
    private WebElement mainLogo;

    @FindBy(xpath = "//a[@class=\"btn btn-default button-plus product_quantity_up\"]")
    private WebElement quantityButtonPlusBeforeCartPage;


    public void clickSignInButton() {
        DriverProvider.getWait().until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void clickFadedShortSleeveTshirts() {
        DriverProvider.getWait().until(ExpectedConditions.elementToBeClickable(fadedShortSleeveTshirts));
        fadedShortSleeveTshirts.click();
    }

    public void clickBlouse() {
        DriverProvider.getWait().until(ExpectedConditions.elementToBeClickable(blouse));
        blouse.click();
    }

    public void clickAddToCart() {
        DriverProvider.getWait().until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void clickProceedToCheckoutButton() {
        DriverProvider.getWait().until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }

    public void clickCrossButton() {
        DriverProvider.getWait().until(ExpectedConditions.visibilityOf(crossButton));
        crossButton.click();
    }

    public void clickMainLogo() {
        DriverProvider.getWait().until(ExpectedConditions.visibilityOf(mainLogo));
        mainLogo.click();
    }

    public void clickQuantityButtonPlusBeforeCartPage() {
        DriverProvider.getWait().until(ExpectedConditions.visibilityOf(quantityButtonPlusBeforeCartPage));
        quantityButtonPlusBeforeCartPage.click();
    }

}
