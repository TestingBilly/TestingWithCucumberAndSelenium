package stepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToWishlistTest {
    public WebDriver driver;
    double cheapest;


    @Given("I add four different products to my wish list")
    public void user_add_items_to_wishlist(){
        AddItemsToWishlist addItemsToWishlist = new AddItemsToWishlist(driver);
        addItemsToWishlist.setUp();
        addItemsToWishlist.addItemsToWishList();
    }

    @When("I view my wishlist table")
    public void user_views_wishlist(){
        LookAtWishList lookAtWishList = new LookAtWishList(driver);
        lookAtWishList.lookAtWishList();
    }

    @Then("I find total four selected items in my Wishlist")
    public void total_of_items_selected(){
        FindTotalInWishList findTotalInWishList = new FindTotalInWishList(driver);
        findTotalInWishList.lookAtWishListAndGetPrices();
    double total = findTotalInWishList.total;
    System.out.println(total);}

    @When("I search for lowest price product")
    public void lowest_price_item_found(){
        FindTotalInWishList findTotalInWishList = new FindTotalInWishList(driver);
        findTotalInWishList.lookAtWishListAndGetPrices();

        double x, size;
        size = findTotalInWishList.prices.length;

        for (int i = 0; i<size; i++){
            for (int j = i+1; j<size; j++){
                if(findTotalInWishList.prices[i]>findTotalInWishList.prices[j]){
                    x = findTotalInWishList.prices[i];
                    findTotalInWishList.prices[i] = findTotalInWishList.prices[j];
                    findTotalInWishList.prices[j] = x;
                    cheapest = findTotalInWishList.prices[j];
                }
            }

        }
        System.out.println(cheapest);
    }

    @And("I am able to add the lowest price item to my cart")
    public void lowest_item_in_cart(){
        FindTotalInWishList findTotalInWishList = new FindTotalInWishList(driver);
        findTotalInWishList.lookAtWishListAndGetPrices();

        if (cheapest == findTotalInWishList.prices[0]){
            driver.findElement(By.xpath("//td[6]")).click();
        }
        if (cheapest == findTotalInWishList.prices[1]){
            driver.findElement(By.xpath("//tr[2]/td[6]")).click();
        }
        if (cheapest == findTotalInWishList.prices[2]){
            driver.findElement(By.xpath("//tr[3]/td[6]")).click();
        }
        if (cheapest == findTotalInWishList.prices[3]){
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
        cartCheck.tearDown();
    }
}
