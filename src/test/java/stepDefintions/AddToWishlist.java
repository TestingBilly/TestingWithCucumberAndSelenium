package stepDefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddToWishlist {
    public WebDriver driver;


    @Given("I add four different products to my wish list")
    public void user_add_items_to_wishlist(){
        new AddItemsToWishlist();
    }

    @When("I view my wishlist table")
    public void user_views_wishlist(){
        new LookAtWishList();
    }

    @Then("I find total four selected items in my Wishlist")
    public void total_of_items_selected(){
        
    }
}
