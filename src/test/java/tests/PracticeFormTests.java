package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void PracticeFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.SPORTS);
        hobbies.add(Hobbies.MUSIC);
        Student student = Student.builder()
                .firstName("Polina")
                .lastName("Gagarina")
                .email("avrora55@gmail.com")
                .gender(Gender.FEMALE)
                .mobile("0123456789")
                .dateOfBirth("22 Apr 2003")
                .subjects("Maths, Chemistry, English")
                .hobbies(hobbies)
                .picture("")
                .address("Street 1")
                .state(StateCity.NCR.getState())
                .city(StateCity.NCR.getCity()[0])
                .build();

        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
//        Assert.assertTrue(practiceFormPage.validateModalMessage
//                ("Wrong"), "Wrong test");
        System.out.println("test working");
        Assert.assertTrue(practiceFormPage.validateModalMessage
                ("Thanks for submitting the form"));
    }

    @Test
    public void PracticeFormPositiveWithSoftAssertTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.SPORTS);
        hobbies.add(Hobbies.MUSIC);
        Student student = Student.builder()
                .firstName("Polina")
                .lastName("Gagarina")
                .email("avrora55@gmail.com")
                .gender(Gender.FEMALE)
                .mobile("0123456789")
                .dateOfBirth("22 Apr 2003")
                .subjects("Maths, Chemistry, English")
                .hobbies(hobbies)
                .picture("")
                .address("Street 1")
                .state(StateCity.NCR.getState())
                .city(StateCity.NCR.getCity()[0])
                .build();

        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
//        softAssert.assertTrue(practiceFormPage.validateModalMessage
//                ("Wrong"), "Wrong test");
//        System.out.println("test working");
        softAssert.assertTrue(practiceFormPage.validateModalMessage
                ("Thanks for submitting the form"),
                "validate right message");
        softAssert.assertTrue(getDriver().findElement
                (By.xpath("//tbody/tr[1]/td[2]"))
                .getText().contains(student.getFirstName()),
                "validate firstName");
        softAssert.assertTrue(getDriver().findElement
                (By.xpath("//tbody/tr[2]/td[2]   "))
                .getText().contains(student.getEmail()),
                "validate email");
        softAssert.assertTrue(getDriver().findElement
                (By.xpath("//tbody/tr[4]/td[2]   "))
                .getText().contains(student.getMobile()),
                "validate mobile");
        softAssert.assertTrue(getDriver().findElement
                (By.xpath("//tbody/tr[9]/td[2]   "))
                .getText().contains(student.getAddress()),
                "validate address");
        softAssert.assertTrue(getDriver().findElement
                (By.xpath("//tbody/tr[10]/td[2]   "))
                .getText().contains(student.getState()),
                "validate state");
       softAssert.assertAll();
    }
}
