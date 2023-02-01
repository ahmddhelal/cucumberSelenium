package steps;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Hooks {

    WebDriver driver = Base.driver;
    Base base = new Base();

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }



    @Before
    public void setup() {
        base.setup();
    }

    @After
    public void quit() {
        base.quit();
    }
}
