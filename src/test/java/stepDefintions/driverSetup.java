package stepDefintions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class driverSetup {
    static WebDriver driver;
    @Before

    public static WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://testscriptdemo.com");
        return driver;
    }

    public static void tearDown(WebDriver driver) {
        driver.quit();
    }
}
