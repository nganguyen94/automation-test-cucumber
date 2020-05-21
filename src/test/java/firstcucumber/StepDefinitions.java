package firstcucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class StepDefinitions {

    WebDriver driver;
    String txtProductName;

    public StepDefinitions()
    {
        this.driver= Hooks.driver;
    }

    @Given("The Tiki page is open")
    public void the_Tiki_page_is_open() {
        //Open login
        this.driver.get("https://tiki.vn/");
    }
    @When("^The user find product (.*) and buy any product in list products result$")
    public void the_user_find_product_productName_and_buy_any_product_in_list_products_result(String txtSearch) {
        // Get element
        WebElement txtElementSearch = this.driver.findElement(By.cssSelector("input.FormSearch__Input-sc-1fwg3wo-2"));
        WebElement btnSearch = this.driver.findElement(By.cssSelector("button.FormSearch__Button-sc-1fwg3wo-3"));

        // Search by key
        txtElementSearch.sendKeys(txtSearch);
        btnSearch.click();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Get list products result
        List<WebElement> resultProducts = this.driver.findElements(By.cssSelector("div.product-item"));

        //choose product
        Random rd = new Random();
        int findProduct = rd.nextInt(resultProducts.size());
        WebElement elementProductBuy = resultProducts.get(findProduct);
        txtProductName = elementProductBuy.findElement(By.cssSelector("a")).getAttribute("title");

        // Go to page detail
        elementProductBuy.click();

        // Buy product
        WebElement btnBuy = this.driver.findElement(By.cssSelector("button.btn-add-to-cart"));
        btnBuy.click();
    }

    @Then("The shopping cart has product selected")
    public void the_shopping_cart_has_product_productName() {
        // Go to the cart
        this.driver.get("https://tiki.vn/checkout/cart?src=header_cart");
        List<WebElement> listProductCart = this.driver.findElements(By.cssSelector("a.cart-products__name"));
        boolean checkExisted = false;
        for(WebElement el: listProductCart)
        {
            if (el.getText().equals(txtProductName)) {
                checkExisted = true;
            }
        }
        Assert.assertTrue(checkExisted);
    }
}