package steps;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ContactUs {

    WebDriver driver = Base.driver ;

    @Given("user open the website")
    public void userOpenTheWebsite() {
        driver.get("https://saucelabs.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @When("user click on contact sales button")
    public void userClickOnContactSalesButton() throws InterruptedException {
        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/ul/li[1]/ul[2]/li[6]/div[1]/div/a"));
        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/ul/li[1]/ul[2]/li[6]/div[2]/div/div/div/ul/li/div/ul/li[1]/div/ul/li[1]/div/ul/li/a/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(e1).perform();
        actions.moveToElement(e2).click().build().perform();

    }

    @Then("business email field should be visible")
    public void businessEmailFieldShouldBeVisible() {
        Assert.assertTrue(driver.findElement(By.id("Email")).isDisplayed());
    }
}

