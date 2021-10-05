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

import java.util.concurrent.TimeUnit;

public class AddToWishlistSteps {
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
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

        price1 = driver.findElement(By.xpath("//td[4]")).getText();
        price1 = price1.replaceAll("[^\\d.]", "");
        price1=price1.substring(4);
        itemPrice1 = Double.parseDouble(price1);
        price2 = driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
        price2 = price2.replaceAll("[^\\d.]", "");
        price2=price2.substring(4);
        itemPrice2 = Double.parseDouble(price2);
        price3 = driver.findElement(By.xpath("//tr[3]/td[4]")).getText();
        price3 = price3.replaceAll("[^\\d.]", "");
        price3=price3.substring(4);
        itemPrice3 = Double.parseDouble(price3);
        price4 = driver.findElement(By.xpath("//tr[4]/td[4]")).getText();
        price4 = price4.replaceAll("[^\\d.]", "");
        price4=price4.substring(4);
        itemPrice4 = Double.parseDouble(price4);
        prices = new double[]{itemPrice4, itemPrice3, itemPrice2, itemPrice1};
        total = itemPrice1+itemPrice2+itemPrice3+itemPrice4;
        System.out.println(total);}

    @When("I search for lowest price product")
    public void lowest_price_item_found() {
        driver.get("https://testscriptdemo.com/?page_id=233&wishlist-action");

        price1 = driver.findElement(By.xpath("//td[4]")).getText();
        price1 = price1.replaceAll("[^\\d.]", "");
        price1 = price1.substring(4);
        itemPrice1 = Double.parseDouble(price1);
        price2 = driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
        price2 = price2.replaceAll("[^\\d.]", "");
        price2 = price2.substring(4);
        itemPrice2 = Double.parseDouble(price2);
        price3 = driver.findElement(By.xpath("//tr[3]/td[4]")).getText();
        price3 = price3.replaceAll("[^\\d.]", "");
        price3 = price3.substring(4);
        itemPrice3 = Double.parseDouble(price3);
        price4 = driver.findElement(By.xpath("//tr[4]/td[4]")).getText();
        price4 = price4.replaceAll("[^\\d.]", "");
        price4 = price4.substring(4);
        itemPrice4 = Double.parseDouble(price4);
        prices = new double[]{itemPrice4, itemPrice3, itemPrice2, itemPrice1};
        //System.out.println(prices[0] + "" + prices[1] + "" + prices[2] + "" + prices[3]);

       cheapest = Integer.MAX_VALUE;
        int index = 0;

        while(index<prices.length){
            if(cheapest>prices[index]){
                cheapest = prices[index];
            }
            index++;
        }

        System.out.println(cheapest);
    }

    @And("I am able to add the lowest price item to my cart")
    public void lowest_item_in_cart(){
        driver.get("https://testscriptdemo.com/?page_id=233&wishlist-action");

        price1 = driver.findElement(By.xpath("//td[4]")).getText();
        price1 = price1.replaceAll("[^\\d.]", "");
        price1=price1.substring(4);
        itemPrice1 = Double.parseDouble(price1);
        price2 = driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
        price2 = price2.replaceAll("[^\\d.]", "");
        price2=price2.substring(4);
        itemPrice2 = Double.parseDouble(price2);
        price3 = driver.findElement(By.xpath("//tr[3]/td[4]")).getText();
        price3 = price3.replaceAll("[^\\d.]", "");
        price3=price3.substring(4);
        itemPrice3 = Double.parseDouble(price3);
        price4 = driver.findElement(By.xpath("//tr[4]/td[4]")).getText();
        price4 = price4.replaceAll("[^\\d.]", "");
        price4=price4.substring(4);
        itemPrice4 = Double.parseDouble(price4);
        prices = new double[]{itemPrice4, itemPrice3, itemPrice2, itemPrice1};
        total = itemPrice1+itemPrice2+itemPrice3+itemPrice4;

        if (cheapest == itemPrice1){
            driver.findElement(By.xpath("//td[6]")).click();
        }
        else if (cheapest == itemPrice2){
            driver.findElement(By.xpath("//tr[2]/td[6]")).click();
        }
        else if (cheapest == itemPrice3){
            driver.findElement(By.xpath("//tr[3]/td[6]")).click();
        }
        else if (cheapest == itemPrice4){
            driver.findElement(By.xpath("//tr[4]/td[6]")).click();
        }

    }

    @Then("I am able to verify the item in my cart")
    public void item_in_cart_check(){
        driver.get("https://testscriptdemo.com/?page_id=299");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".header-right > .header-cart .la")).click();

        String toalCart = driver.findElement(By.xpath("//div/table/tbody/tr[2]")).getText();
        toalCart=toalCart.replaceAll("[^\\d.]", "");

        Double cartTotal = Double.parseDouble(toalCart);
        System.out.println(cartTotal);
        System.out.println(cheapest);
        if (cartTotal != cheapest){
            System.out.println("ERROR");
        }
        if (cartTotal == cheapest){
            System.out.println("This Worked");
        }
        driverSetup.tearDown(driver);
    }
}
