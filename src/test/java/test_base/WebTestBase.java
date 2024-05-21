package test_base;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import site_constants.SiteConstants;

import java.util.concurrent.TimeUnit;

public class WebTestBase {
    //LoginPage page;
    public static WebDriver webDriver;

    @BeforeSuite
    @Parameter(names = "browserName")
    public void startDriver(@Optional("chrome") String browserName) {
        ChromeOptions options = new ChromeOptions();

        // Set language to English
        options.addArguments("--lang=en-GB");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        //page = new LoginPage(driver);

        webDriver.manage().window().maximize();
        webDriver.navigate().to(SiteConstants.baseUrl);
        Reporter.log("We used Google Chrome Ver 80 for this test");
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void endDriver() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();


    }
}





