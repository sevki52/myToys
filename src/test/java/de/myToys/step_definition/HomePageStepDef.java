package de.myToys.step_definition;

import de.myToys.pages.DashboardPage;
import de.myToys.utilities.ConfigurationReader;
import de.myToys.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class HomePageStepDef {

    DashboardPage dashboardPage = new DashboardPage();


    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        String url = ConfigurationReader.get("myToys.url");
        Driver.get().get(url);

        dashboardPage.cookies.click();

        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals("https://www.mytoys.de/",actualUrl);
    }
}

