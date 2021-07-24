package pages.myStore;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Page;

public class MainPage extends Page {
    private static String URL = "http://automationpractice.com/";

    @Override
    public void open() {
        driver.get(URL);
    }

    @FindBy(xpath = "//div[@class='header_user_info']")
    private WebElement signInButton;

    public void clickSignInButton() {
        DriverProvider.getWait().until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

}
