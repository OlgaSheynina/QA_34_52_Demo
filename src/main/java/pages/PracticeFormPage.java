package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(id = "firstName")
    WebElement inputFirstName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputEmail;
    @FindBy(id = "userNumber")
    WebElement inputMobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement inputDateOfBirth;
    @FindBy(id = "subjectsInput")
    WebElement inputSubjects;
    @FindBy(id = "currentAddress")
    WebElement textareaCurAdd;
    @FindBy(id = "react-select-3-input")
    WebElement inputState;
    @FindBy(id = "react-select-4-input")
    WebElement inputCity;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement btnSubmit;
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalMessage;

    public void typePracticeForm(Student student) {
        inputFirstName.sendKeys(student.getFirstName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        chooseGender(student.getGender());
        inputMobile.sendKeys(student.getMobile());
//        inputDateOfBirth.click();
//        inputDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        chooseHobbies(student.getHobbies());
        hideFooter();
        textareaCurAdd.sendKeys(student.getAddress());
        typeStateCity(student.getState(), student.getCity());
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", btnSubmit);
        scrollActions();
        btnSubmit.click();
    }

    private void chooseGender(Gender gender) {
        driver.findElement(By.id(gender.getLocator())).click();
    }

    private void typeDateOfBirth(String dateOfBirth) {
        inputDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win")) {
            inputDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            if (operationSystem.startsWith("Mac")) {
                inputDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
                inputDateOfBirth.sendKeys(dateOfBirth);
                inputDateOfBirth.sendKeys(Keys.ENTER);
            }
        }
    }

    private void typeSubjects(String subjects) {
        inputSubjects.click();
        String[] strSubjects = subjects.trim().split(",");
        for (String s : strSubjects) {
            inputSubjects.sendKeys(s);
            inputSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void chooseHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case SPORTS -> driver.findElement(By.xpath(h.getLocator())).click();
                case READING -> driver.findElement(By.xpath(h.getLocator())).click();
                case MUSIC -> driver.findElement(By.xpath(h.getLocator())).click();
            }
            WebElement hobbyElement = driver.findElement(By.xpath(h.getLocator()));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", hobbyElement);
        }
    }


    private void typeStateCity(String state, String city) {
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);

        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
    }

    public boolean validateModalMessage(String text) {
        return isTextInElementPresent(modalMessage, text);
    }
}



