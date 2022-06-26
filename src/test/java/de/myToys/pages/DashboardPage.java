package de.myToys.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
    @FindBy(xpath = "//button[normalize-space(text())='Zustimmen']")
    public WebElement cookies;
}
