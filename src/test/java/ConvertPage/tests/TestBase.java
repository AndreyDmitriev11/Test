package ConvertPage.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ConvertPage.app.Application;
/**
 * Created by Андрей on 10.05.2017.
 */

public class TestBase {

    private WebDriver driver;
    public WebDriverWait wait;
    public Application app;



    @BeforeClass
    public void start() {

        //this is test
        //this part is a trick for access https like real user
        System.setProperty("webdriver.chrome.driver","J:\\Tools\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/Андрей/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        app = new Application(driver);

    }


    @AfterClass
    public void stop() {

        driver.quit();
        driver = null;
    }

}


