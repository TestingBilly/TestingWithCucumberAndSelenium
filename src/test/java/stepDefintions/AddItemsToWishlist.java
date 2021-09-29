package stepDefintions;// Generated by Selenium IDE


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class AddItemsToWishlist {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

//    public void tearDown() {
//        driver.quit();
//    }

    public void addItemsToWishList() {
        driver.get("https://testscriptdemo.com/");
        driver.manage().window().setSize(new Dimension(1296, 736));
        driver.findElement(By.cssSelector(".elementor-shortcode:nth-child(1) .product:nth-child(1) > .product-compare-wishlist:nth-child(3) span:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".elementor-shortcode:nth-child(1) .product:nth-child(2) > .product-compare-wishlist:nth-child(3) span:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".elementor-shortcode:nth-child(1) .product:nth-child(3) > .product-compare-wishlist:nth-child(3) span:nth-child(2)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".elementor-shortcode:nth-child(1) .product:nth-child(3) > .product-compare-wishlist:nth-child(3) span:nth-child(2)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".add-to-wishlist-23 span")).click();
    }
}
