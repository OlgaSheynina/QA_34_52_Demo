package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

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
                .state("NCR")
                .city("City")
                .build();

        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
    }
}
