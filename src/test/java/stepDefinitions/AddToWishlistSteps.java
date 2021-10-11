package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import otherFunctions.driverSetup;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AddToWishlistSteps {
    int cheapestIndex;
    WebDriver driver;
    double total;
    double [] prices = new double[4];

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
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

        for(int i = 1; i < prices.length + 1; i++) {
            String dString = driver.findElement(By.xpath("//tr["+i+"]/td[4]")).getText();
            dString = dString.replaceAll("[^\\d.]", "");
            dString = dString.substring(4);
            prices[i] = Double.parseDouble(dString);
        }
        total = Arrays.stream(prices).sum();
        System.out.println(total);
        //ADD AN ASSERT METHOD HERE, YOU'RE NOT TESTING ANYTHING
    }

    @When("I search for lowest price product")
    public void lowest_price_item_found() {

        double cheapest = Double.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < cheapest) {
                cheapest = prices[i];
                cheapestIndex = i;
            }
        }
        System.out.println(cheapest);
    }

    @And("I am able to add the lowest price item to my cart")
    public void lowest_item_in_cart(){
        driver.findElement(By.xpath("//tr["+(cheapestIndex+1)+"]/td[6]")).click();
    }

    @Then("I am able to verify the item in my cart")
    public void item_in_cart_check(){
        driver.get("https://testscriptdemo.com/?page_id=299");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".header-right > .header-cart .la")).click();

        String totalCart = driver.findElement(By.xpath("//div/table/tbody/tr[2]")).getText();
        totalCart=totalCart.replaceAll("[^\\d.]", "");

        Double cartTotal = Double.parseDouble(totalCart);
        System.out.println(cartTotal);
        System.out.println(prices[cheapestIndex]);
        if (cartTotal != prices[cheapestIndex]){
            System.out.println("ERROR");
        }
        if (cartTotal == prices[cheapestIndex]){
            System.out.println("This Worked");
        }
        driverSetup.tearDown(driver);
        //ADD AN ASSERT METHOD HERE, YOU'RE NOT TESTING ANYTHING
    }
}
