package stepDefintions;
// Generated by Selenium IDE
import io.cucumber.java.eo.Do;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.sql.Array;
import java.util.*;
public class FindTotalInWishList {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    double itemPrice1;
    double itemPrice2;
    double itemPrice3;
    double itemPrice4;
    double total;
    double [] prices;
    String price1;
    String price2;
    String price3;
    String price4;
//
//    public void setUp() {
//        driver = new ChromeDriver();
//        js = (JavascriptExecutor) driver;
//        vars = new HashMap<String, Object>();
//    }

//    public void tearDown() {
//        driver.quit();
//    }
    public void lookAtWishListAndGetPrices() {
        driver.get("https://testscriptdemo.com/");
        driver.manage().window().setSize(new Dimension(1296, 736));
        driver.findElement(By.cssSelector(".header-wishlist:nth-child(3) .lar")).click();
        price1 = driver.findElement(By.xpath("//td[4]")).getText();
        itemPrice1 = Double.parseDouble(price1);
        price2 = driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
        itemPrice2 = Double.parseDouble(price2);
        price3 = driver.findElement(By.xpath("//tr[3]/td[4]")).getText();
        itemPrice3 = Double.parseDouble(price3);
        price4 = driver.findElement(By.xpath("//tr[4]/td[4]")).getText();
        itemPrice4 = Double.parseDouble(price4);
        prices = new double[]{itemPrice4, itemPrice3, itemPrice2, itemPrice1};
        total = itemPrice1+itemPrice2+itemPrice3+itemPrice4;
    }
}
