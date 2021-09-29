package stepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddToWishlist {
    public WebDriver driver;
    double cheapest;


    @Given("I add four different products to my wish list")
    public void user_add_items_to_wishlist(){
        new AddItemsToWishlist();
    }

    @When("I view my wishlist table")
    public void user_views_wishlist(){
        new LookAtWishList();
    }

    @Then("I find total four selected items in my Wishlist")
    public void total_of_items_selected(){ FindTotalInWishList findTotalInWishList = new FindTotalInWishList();
    double total = findTotalInWishList.total;
    System.out.println(total);}

    @When("I search for lowest price product")
    public void lowest_price_item_found(){FindTotalInWishList findTotalInWishList = new FindTotalInWishList();

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
    }

    @And("I am able to add the lowest price item to my cart")
    public void lowest_item_in_cart(){}

    @Then("I am able to verify the item in my cart")
    public void item_in_cart_check(){}
}
