package pages.myStore;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Page;

public class AuthenticationPage extends Page {


    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    @FindBy(id = "email")
    private WebElement emailLabel;

    @FindBy(id = "passwd")
    private WebElement passwordLabel;


    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li")
    private WebElement getErrorMessageOnAuthenticationPage;


    public void clickSubmitLoginButton() {
        DriverProvider.getWait().until(ExpectedConditions.visibilityOf(submitLoginButton));
        submitLoginButton.click();
    }

    public String getErrorEmailAddressRequired() {
        final String EmailAddressRequired = getErrorMessageOnAuthenticationPage.getText();
        return EmailAddressRequired;
    }

    public void addWrongEmailAddress() {
        emailLabel.sendKeys("qwerty.gmail.pl");
    }

    public void addCorrectEmailAddress() {
        emailLabel.sendKeys("qwerty@gmail.pl");
    }

    public void addPassword() {
        passwordLabel.sendKeys("1234567");
    }

    private static String URL = "http://automationpractice.com/index.php";

    @Override
    public void open() {
        driver.get(URL);
    }
}
