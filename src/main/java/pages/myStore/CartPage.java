package pages.myStore;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Page;

public class CartPage extends Page {
    private static String URL = "http://automationpractice.com/index.php";


    @FindBy(xpath = "//span[@class=\"label label-success\"]")
    private WebElement productAvailabilityOnCart;

    @FindBy(id = "total_price")
    private WebElement productFinalPriceOnCartPage;

    @FindBy(xpath = "//a[@class=\"cart_quantity_up btn btn-default button-plus\"]")
    private WebElement quantityButtonPlusOnCartPage;

    @FindBy(xpath = "//a[@class=\"cart_quantity_delete\"]")
    private WebElement deleteButtonOnCartPage;

    //    @FindBy(xpath = "//p[@class=\"alert alert-warning\"]")
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement emptyBasketInfo;

    public String getProductAvailabilityOnCart() {
        final String checkProductAvailabilityOnCart = productAvailabilityOnCart.getText();
        return checkProductAvailabilityOnCart;
    }

    public String getProductPriceOnCart() {
        DriverProvider.getWait().until(ExpectedConditions.visibilityOf(productFinalPriceOnCartPage));
        final String checkProductPriceOnCart = productFinalPriceOnCartPage.getText();
        return checkProductPriceOnCart;
    }

    public void clickQuantityButtonPlusOnCartPage() {
        DriverProvider.getWait().until(ExpectedConditions.elementToBeClickable(quantityButtonPlusOnCartPage));
        quantityButtonPlusOnCartPage.click();
    }

    public void clickDeleteButtonOnCartPage() {
        DriverProvider.getWait().until(ExpectedConditions.elementToBeClickable(deleteButtonOnCartPage));
        deleteButtonOnCartPage.click();
    }

    public String getEmptyBasketInfo() {
        DriverProvider.getWait().until(ExpectedConditions.visibilityOf(emptyBasketInfo));
        final String checkInfoAboutEmptyBasket = emptyBasketInfo.getText();
        return checkInfoAboutEmptyBasket;
    }

    @Override
    public void open() {
        driver.get(URL);
    }
}
