package de.myToys.step_definition;

import de.myToys.pages.ShoppingPage;
import de.myToys.utilities.BrowserUtils;
import de.myToys.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShoppingPageStepDef {
    ShoppingPage shoppingPage = new ShoppingPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);


    @When("the user writes {string}  on the search box")
    public void the_user_writes_on_the_search_box(String trampoline) {
        shoppingPage.searchBar.sendKeys(trampoline);
    }

    @And("the user clicks on search button")
    public void the_user_clicks_on_search_button() {
        BrowserUtils.waitForClickablility(shoppingPage.searchBarButton,3);
        shoppingPage.searchBarButton.click();
    }

    @And("the user sorts products by highest price")
    public void theUserSortsProductsByHighestPrice() {
      BrowserUtils.waitForVisibility(shoppingPage.sortierung,3);
        Select dropdown = new Select(shoppingPage.sortierung);

       dropdown.selectByIndex(2);

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(shoppingPage.products.get(5)).build().perform();
    }

    @Then("Verify that the first {int} products have been sorted correctly")
    public void verify_that_the_first_products_have_been_sorted_correctly(Integer int1) {
        int maxPrice = Integer.MAX_VALUE;
        int actualPrice;

        for (int i = 0; i < 5; i++) {
            System.out.println("shoppingPage.products.get(i).getText() = " + shoppingPage.products.get(i).getText());
            if (shoppingPage.products.get(i).getText().length() == 10) {
                String[] allText = shoppingPage.products.get(i).getText().split("€");
                System.out.println("allText[0] = " + allText[0]);
                String priseText = allText[0].substring(0,1) + allText[0].substring(2, 5) + allText[0].substring(6, 8);
                actualPrice = Integer.parseInt(priseText);
                System.out.println("actualPrice = " + actualPrice);
            }else{
                String text = shoppingPage.products.get(i).getText();
                String reducePrise = text.substring(15,16) + text.substring(17,20) + text.substring(21,23);
                actualPrice = Integer.parseInt(reducePrise);
                System.out.println("actualPrice = " + actualPrice);
            }

            Assert.assertTrue("The first 5 products have not been sorted correctly",actualPrice<maxPrice);
            maxPrice=actualPrice;
        }
    }
     //second scenario
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
        shoppingPage.firstPriceBox.sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.elementToBeSelected(shoppingPage.firstPriceBox));
        shoppingPage.firstPriceBox.sendKeys("500");
        wait.until(ExpectedConditions.elementToBeClickable(shoppingPage.secondPriceBox));
        shoppingPage.secondPriceBox.sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.elementToBeClickable(shoppingPage.secondPriceBox));
        shoppingPage.secondPriceBox.sendKeys("1000");
    }
    @And("the user clicks on preis submit button")
    public void the_user_clicks_on_preis_submit_button() {
        shoppingPage.priceSubmitBtn.click();

    }
    @And("the user clicks on result")
    public void the_user_clicks_on_result() {
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


    }
    }