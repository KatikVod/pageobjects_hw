package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillAllFieldsTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Ekaterina")
                .setLastName("Vodolazhskaia")
                .setEmail("testmail@gmail.com")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setDateOfBirth("27", "June", "1993")
                .setSubjects("Maths")
                .setSubjects("Physics")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadPicture("picture.png")
                .setCurrentAddress("Moscow, Russia")
                .setState("NCR")
                .setCity("Gurgaon")
                .submit()

                .checkResult("Student Name", "Ekaterina Vodolazhskaia")
                .checkResult("Student Email", "testmail@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "27 June,1993")
                .checkResult("Subjects", "Maths, Physics")
                .checkResult("Hobbies", "Reading, Music")
                .checkResult("Picture", "picture.png")
                .checkResult("Address", "Moscow, Russia")
                .checkResult("State and City", "NCR Gurgaon");

    }

    @Test
    void fillOnlyRequiredFieldsTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setGender("Male")
                .setUserNumber("0000000000")
                .setDateOfBirth("13", "May", "1980")
                .submit()

                .checkResult("Student Name", "Ivan Petrov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0000000000")
                .checkResult("Date of Birth", "13 May,1980");
    }

    @Test
    void emptyFirstNameTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setLastName("Ivanov")
                .setGender("Other")
                .setUserNumber("1111111111")
                .setDateOfBirth("31", "January", "1999")
                .submit()

                .checkEmptyFirstNameResult();

    }
}
