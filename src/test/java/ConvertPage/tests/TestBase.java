package ConvertPage.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ConvertPage.app.Application;

import java.time.temporal.ChronoUnit;

/**
 * Created by Андрей on 10.05.2017.
 * Updated by Александр on 17.04.2022.
 */

public class TestBase {

    private WebDriver driver;
    public WebDriverWait wait;
    public Application app;



    @BeforeClass
    public void start() {

        //this is test
        //this part is a trick for access https like real user
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MO\\IdeaProjects\\Test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/MO/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, java.time.Duration.of(10L, ChronoUnit.SECONDS) );
        app = new Application(driver);

    }


    @AfterClass
    public void stop() {

        driver.quit();
        driver = null;
    }

}


