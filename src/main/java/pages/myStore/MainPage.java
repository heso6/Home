package pages.myStore;

import pages.Page;

public class MainPage extends Page {
    private static String URL = "http://automationpractice.com/";

    @Override
    public void open() {
        driver.get(URL);
    }


}
