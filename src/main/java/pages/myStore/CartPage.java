package pages.myStore;

import pages.Page;

public class CartPage extends Page {


    private static String URL = "http://automationpractice.com/index.php";

    @Override
    public void open() {
        driver.get(URL);
    }
}
