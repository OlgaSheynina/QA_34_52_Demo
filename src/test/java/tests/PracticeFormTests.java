package tests;

import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void PracticeFormPositiveTest() {
        Student student = Student.builder()
                .firstName("Polina")
                .lastName("Gagarina")
                .email("avrora55@gmail.com")
                .gender("female")
                .mobile("0123456789")
                .dateOfBirth("22 Apr 2003")
                .subjects("Maths, Chemistry, English")
                .hobbies("Sport")
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
