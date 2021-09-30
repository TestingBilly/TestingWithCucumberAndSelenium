package stepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AddToWishlistTest {
    double cheapest;
    WebDriver driver;
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

    @Given("I add four different products to my wish list")
    public void user_add_items_to_wishlist() {
        driver = driverSetup.setUp();
        driver.get("https://testscriptdemo.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.xpath("//li[2]/div/div[2]/div/div/a/span")).click();
        {
            WebElement element = driver.findElement(By.xpath("//li[2]/div/div[2]/div/div/a/span"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.xpath("//li[1]/div/div[2]/div/div/a/span")).click();
        driver.findElement(By.xpath("//li[3]/div/div[2]/div/div/a/span")).click();
        driver.findElement(By.xpath("//li[4]/div/div[2]/div/div/a/span")).click();
    }

    @When("I view my wishlist table")
    public void user_views_wishlist(){
        driver.get("https://testscriptdemo.com/?page_id=233&wishlist-action");
    }

    @Then("I find total four selected items in my Wishlist")
    public void total_of_items_selected(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
        System.out.println(total);}

    @When("I search for lowest price product")
    public void lowest_price_item_found(){
        price1 = driver.findElement(By.xpath("//td[4]")).getText();
        itemPrice1 = Double.parseDouble(price1);
        price2 = driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
        itemPrice2 = Double.parseDouble(price2);
        price3 = driver.findElement(By.xpath("//tr[3]/td[4]")).getText();
        itemPrice3 = Double.parseDouble(price3);
        price4 = driver.findElement(By.xpath("//tr[4]/td[4]")).getText();
        itemPrice4 = Double.parseDouble(price4);
        prices = new double[]{itemPrice4, itemPrice3, itemPrice2, itemPrice1};

        double x, size;
        size = prices.length;

        for (int i = 0; i<size; i++){
            for (int j = i+1; j<size; j++){
                if(prices[i]>prices[j]){
                    x = prices[i];
                    prices[i] = prices[j];
                    prices[j] = x;
                    cheapest = prices[j];
                }
            }

        }
        System.out.println(cheapest);
    }

    @And("I am able to add the lowest price item to my cart")
    public void lowest_item_in_cart(){
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

        if (cheapest == prices[0]){
            driver.findElement(By.xpath("//td[6]")).click();
        }
        if (cheapest == prices[1]){
            driver.findElement(By.xpath("//tr[2]/td[6]")).click();
        }
        if (cheapest == prices[2]){
            driver.findElement(By.xpath("//tr[3]/td[6]")).click();
        }
        if (cheapest == prices[3]){
            driver.findElement(By.xpath("//tr[4]/td[6]")).click();
        }

    }

    @Then("I am able to verify the item in my cart")
    public void item_in_cart_check(){
        CartCheck cartCheck = new CartCheck(driver);
        cartCheck.cartCheck();
        if (cartCheck.cartTotal != cheapest){
            System.out.println("ERROR");
        }
        if (cartCheck.cartTotal == cheapest){
            System.out.println("This Worked");
        }
        driverSetup.tearDown(driver);
    }
}
