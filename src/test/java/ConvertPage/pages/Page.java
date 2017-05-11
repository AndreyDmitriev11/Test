package ConvertPage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Андрей on 10.05.2017.
 */
public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;

        //set explicit wait
        wait = new WebDriverWait(driver, 10);
    }
}
