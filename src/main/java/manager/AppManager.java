package manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AppManager {
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}