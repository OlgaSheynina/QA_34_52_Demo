package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        pause(3000);
        hideFooter();
        pause(3000);
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
        WebElement btnTextBox = driver.findElement
                (By.cssSelector("#item-0"));
        btnTextBox.click();
        WebElement btnRadioButton = driver.findElement
                (By.linkText("Radio Button"));
        btnRadioButton.click();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        scrollActions();
        WebElement btnBookStore = driver.findElement
                (By.cssSelector("div.category-cards a:last-child"));
        btnBookStore.click();
        pause(3000);
        driver.navigate().back();
        WebElement btnForms = driver.findElement
                (By.cssSelector("div.category-cards a:nth-child(2)"));
        btnForms.click();
        driver.navigate().back();
        WebElement textInForms = driver.findElement
                (By.cssSelector("div.category-cards a:nth-child(2) div div div.card-body h5"));
        System.out.println(textInForms.getText());
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

    public void scrollActions() {
        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0, 700).perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}