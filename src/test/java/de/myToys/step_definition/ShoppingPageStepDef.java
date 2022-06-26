package de.myToys.step_definition;

import de.myToys.pages.ShoppingPage;
import de.myToys.utilities.BrowserUtils;
import de.myToys.utilities.ConfigurationReader;
import de.myToys.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShoppingPageStepDef {
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);
    private ShoppingPage shoppingPage ;

    //dependency injection with picoContainer
    public ShoppingPageStepDef(ShoppingPage shoppingPage) { this.shoppingPage = shoppingPage;
        this.shoppingPage = shoppingPage;
    }

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        String url = System.getProperty("base.url") != null ? System.getProperty("base.url") : ConfigurationReader.get("myToys.url");
        Driver.get().get(url);
        shoppingPage.cookies.click();
    }

    @When("the user writes {string}  on the search box")
    public void the_user_writes_on_the_search_box(String trampoline) {
        BrowserUtils.waitForClickablility(shoppingPage.searchBar,5);
        shoppingPage.searchBar.sendKeys(trampoline);
    }

    @And("the user clicks on search button")
    public void the_user_clicks_on_search_button() {
        BrowserUtils.waitForClickablility(shoppingPage.searchBarButton,3);
        shoppingPage.searchBarButton.click();
    }

    @And("the user sorts products by highest price")
    public void theUserSortsProductsByHighestPrice() {
        shoppingPage.selectHighPricedItems();
    }

    @Then("Verify that the first {int} products have been sorted correctly")
    public void verify_that_the_first_products_have_been_sorted_correctly(Integer int1) {
        shoppingPage.selectItems();
    }

    @When("the user clicks on Mehr Filter button")
    public void the_user_clicks_on_Mehr_Filter_button() {
        shoppingPage.mehrFilterButton.click();
   }

    @And("the user clicks on Preis button")
    public void the_user_clicks_on_Preis_button() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingPage.preisButton));
        shoppingPage.preisButton.click();
    }

    @And("the user writes costs between {int} and {int}")
    public void the_user_writes_costs_between_and(Integer int1, Integer int2) {
        shoppingPage.firstPriceBox.click();
        BrowserUtils.waitFor(1);
        shoppingPage.firstPriceBox.sendKeys(Keys.BACK_SPACE, String.valueOf(int1));

        shoppingPage.secondPriceBox.click();
        BrowserUtils.waitFor(1);
        shoppingPage.secondPriceBox.sendKeys(Keys.BACK_SPACE, String.valueOf(int2));
    }

    @And("the user clicks on preis submit button")
    public void the_user_clicks_on_preis_submit_button() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingPage.priceSubmitBtn));
        shoppingPage.priceSubmitBtn.click();
    }

    @And("the user clicks on result")
    public void the_user_clicks_on_result() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingPage.resultBtn));
        shoppingPage.resultBtn.click();
    }

    @And("the user clicks on one product to open detail page")
    public void the_user_clicks_on_one_product_to_open_detail_page() {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView();", BrowserUtils.ScrollToElement());
        shoppingPage.oneItem.click();
    }

    @And("the user adds the product to cart")
    public void the_user_adds_the_product_to_cart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingPage.warenkorbBtn));
        shoppingPage.warenkorbBtn.click();
    }

    @Then("the user verify that the correct product is added to shopping cart")
    public void the_user_verify_that_the_correct_product_is_added_to_shopping_cart() {
        String expectedResult = shoppingPage.nameOfItem_Warenkorb.getText().trim();
        String actualResult = shoppingPage.chosenItemName.getAttribute("innerText").trim();
        Assert.assertTrue("The correct product has not been successfully added to the shopping cart",actualResult.contains(expectedResult));
    }}