package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        WebElement divElements = driver.findElement
                (By.cssSelector("div[class='avatar mx-auto white']"));
        divElements.click();
        pause(3000);
        driver.navigate().back();
        WebElement imgTools = driver.findElement
                (By.cssSelector("img[src='/assets/Toolsqa-DZdwt2ul.jpg']"));
        System.out.println(imgTools.getAttribute("srs"));
        pause(3000);
        driver.navigate().forward();
        pause(3000);
        WebElement btnTextBox = driver.findElement(By.cssSelector("#item-0"));
        btnTextBox.click();


        pause(3000);
        driver.quit();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
