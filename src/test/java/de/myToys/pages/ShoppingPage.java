package de.myToys.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingPage extends BasePage {

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


}