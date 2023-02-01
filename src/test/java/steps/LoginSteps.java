package steps;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {



    WebDriver driver = Base.driver ;

    @Given("user open the website and go to login page")
    public void user_open_the_website_and_go_to_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("user fill username as {string} and password as {string} and click on login 01")
    public void user_fill_email_and_password_and_click_on_login_01(String username, String password) {

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
    }


    @When("user fill username and password and click on login 02")
    public void user_fill_email_and_password_and_click_on_login_02(DataTable dataTable) {

        driver.findElement(By.id("username")).sendKeys(dataTable.cell(0,0));
        driver.findElement(By.id("password")).sendKeys(dataTable.cell(0,1));
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
    }

    @When("user fill {string} and {string} and click on login 03")
    public void user_fill_invalid_credentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
    }

    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page() {

        Boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }


    @Then("user get error message")
    public void user_get_error_message() {
        Boolean isDisplayed = driver.findElement(By.id("flash")).isDisplayed() ;
        Assert.assertTrue(isDisplayed);
    }
}
