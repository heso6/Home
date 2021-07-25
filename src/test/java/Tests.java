import drivers.DriverProvider;
import org.junit.*;
import pages.myStore.AuthenticationPage;
import pages.myStore.CartPage;
import pages.myStore.MainPage;


public class Tests {

    @BeforeClass
    public static void init() {
        System.out.println("Starting all from this class tests...");
    }

    @Before
    public void initEachTest() {
        System.out.println("Starting test...");
    }


    @Test
    public void emptyEmailLabel() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.clickSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.clickSubmitLoginButton();
        Assert.assertEquals(authenticationPage.getErrorEmailAddressRequired(), "An email address required.");
    }

    @Test
    public void wrongEmailAddress() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.clickSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.addWrongEmailAddress();
        authenticationPage.clickSubmitLoginButton();
        Assert.assertEquals(authenticationPage.getErrorEmailAddressRequired(), "Invalid email address.");
    }

    @Test
    public void emptyPasswordLabel() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.clickSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.addCorrectEmailAddress();
        authenticationPage.clickSubmitLoginButton();
        Assert.assertEquals(authenticationPage.getErrorEmailAddressRequired(), "Password is required.");
    }

    @Test
    public void noExistAccount() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.clickSignInButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.addCorrectEmailAddress();
        authenticationPage.addPassword();
        authenticationPage.clickSubmitLoginButton();
        Assert.assertEquals(authenticationPage.getErrorEmailAddressRequired(), "Authentication failed.");
    }


    @Test
    public void addProductToTheCartAndGoToCartPage() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.clickFadedShortSleeveTshirts();
        mainPage.clickAddToCart();
        mainPage.clickProceedToCheckoutButton();

    }

    @Test
    public void addTwoProductToTheCartAndGoToCartPage() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.clickFadedShortSleeveTshirts();
        mainPage.clickAddToCart();
        mainPage.clickCrossButton();
        mainPage.clickMainLogo();
        mainPage.clickBlouse();
        mainPage.clickAddToCart();
        mainPage.clickProceedToCheckoutButton();

    }

    @Test
    public void checkPriceAndProductAvailabilityOnCart() {
        MainPage mainPage = new MainPage();
        CartPage cartPage = new CartPage();
        mainPage.open();
        mainPage.clickFadedShortSleeveTshirts();
        mainPage.clickAddToCart();
        mainPage.clickProceedToCheckoutButton();
        Assert.assertEquals("In stock", cartPage.getProductAvailabilityOnCart());
        Assert.assertEquals("$18.51", cartPage.getProductPriceOnCart());
    }


    @Test
    public void changeQuantityOfProductsInBasket() {
        MainPage mainPage = new MainPage();
        CartPage cartPage = new CartPage();
        mainPage.open();
        mainPage.clickFadedShortSleeveTshirts();
        mainPage.clickAddToCart();
        mainPage.clickProceedToCheckoutButton();
        cartPage.clickQuantityButtonPlusOnCartPage();
    }




    @After
    public void after() {
        System.out.println("Test finished, closing driver...");
        DriverProvider.flush();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All tests finished.");
    }
}

