package stepDefintions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class AddToWishlist {
    public WebDriver driver;

    @Given("I add four different products to my wish list\n")
    public void user_add_items_to_wishlist(String url){
        new AddItemsToWishlist();
    }
}
