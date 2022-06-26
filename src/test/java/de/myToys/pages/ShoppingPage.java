package de.myToys.pages;

import de.myToys.utilities.BrowserUtils;
import de.myToys.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoppingPage extends BasePage {
    @FindBy(xpath = "//button[normalize-space(text())='Zustimmen']")
    public WebElement cookies;

    @FindBy(xpath = "//input[@placeholder='Suchbegriff']")
    public WebElement searchBar;

    @FindBy(css = "div.search-form__container")
    public WebElement searchBarButton;

    @FindBy(xpath = "//div[@class='view-options view-options--top']//select[@name='select']")
    public WebElement sortierung;

    @FindBy(css = "div.prod-tile__price-container")
    public List<WebElement> products;

    @FindBy(css = "div:nth-child(5) > button")
    public WebElement mehrFilterButton;

    @FindBy(css = "button[type='button']:nth-child(14)")
    public WebElement preisButton;

    @FindBy(xpath = "(//input[@type='tel'])[1]")
    public WebElement firstPriceBox;

    @FindBy(xpath = "(//input[@type='tel'])[2]")
    public WebElement secondPriceBox;

    @FindBy(className = "filter-price__btn-container")
    public WebElement priceSubmitBtn;

    @FindBy(css = "span[class$='submit']")
    public WebElement resultBtn;

    @FindBy(css = "a[class='prod-tile__link js-prodlink']")
    public WebElement oneItem;

    @FindBy(css = "button[class*='cart-add js-trigger-layer']")
    public WebElement warenkorbBtn;

    @FindBy(xpath = "(//div[@class='layer__prod-name'])[1]")
    public WebElement nameOfItem_Warenkorb;

    @FindBy(xpath = "//h1[@class='prod-info__name']")
    public WebElement chosenItemName;

    /**
     * Sort highest priced products
     */
    public void selectHighPricedItems() {
        BrowserUtils.waitForVisibility(sortierung, 3);
        Select dropdown = new Select(sortierung);

        dropdown.selectByIndex(2);

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(products.get(5)).build().perform();

    }

    /**
     * select related items required element
     */
    public void selectItems() {
        int maxPrice = Integer.MAX_VALUE;
        int actualPrice;

        for (int i = 0; i < 5; i++) {
            System.out.println("shoppingPage.products.get(i).getText() = " + products.get(i).getText());
            if (products.get(i).getText().length() == 10) {
                String[] allText = products.get(i).getText().split("€");
                System.out.println("allText[0] = " + allText[0]);
                String priseText = allText[0].substring(0, 1) + allText[0].substring(2, 5) + allText[0].substring(6, 8);
                actualPrice = Integer.parseInt(priseText);
                System.out.println("actualPrice = " + actualPrice);
            } else {
                String text = products.get(i).getText();
                String reducePrise = text.substring(15, 16) + text.substring(17, 20) + text.substring(21, 23);
                actualPrice = Integer.parseInt(reducePrise);
                System.out.println("actualPrice = " + actualPrice);
            }
            Assert.assertTrue("The first 5 products have not been sorted correctly", actualPrice < maxPrice);
            maxPrice = actualPrice;
        }
    }
}