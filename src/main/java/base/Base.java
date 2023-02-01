package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties props = new Properties();

    public Base() {
        try {
            File file = new File("properities/config.properities");
            FileInputStream fis = new FileInputStream(file);
            props.load(fis);
        } catch (Error | FileNotFoundException error) {
            System.out.println("File doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void quit() {
        driver.quit();
    }
}
