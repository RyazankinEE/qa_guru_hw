import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaRegistrationForm extends TestBase{

    @Test
    void succesfulRegistrationFullField(){
        open(DEMO_QA + "automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@mail.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("7999252333");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--018").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("bug.png");
        $("#currentAddress").setValue("russia");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Ivanov@mail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7999252333"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("18 May,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("bug.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("russia"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }

    @Test
    void succesfulRegistrationRequiredField(){
        open(DEMO_QA +"automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@mail.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("7999252333");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--018").click();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("bug.png");
        $("#currentAddress").setValue("russia");
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Ivanov@mail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7999252333"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("18 May,1990"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("bug.png"));
    }
    @Test
    void wrongPhoneNumberField(){
        open(DEMO_QA +"automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@mail.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("799925233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--018").click();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("bug.png");
        $("#currentAddress").setValue("russia");
        $("#submit").click();

        $(".table-responsive").shouldBe(hidden);
    }

    @Test
    void wrongRegistrationWithoutStudentName(){
        open(DEMO_QA +"automation-practice-form");
        $("#userEmail").setValue("Ivanov@mail.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("799925233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--018").click();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("bug.png");
        $("#currentAddress").setValue("russia");
        $("#submit").click();

        $(".table-responsive").shouldBe(hidden);
    }

    @Test
    void emptyFormTest(){
        open(DEMO_QA +"automation-practice-form");
        $("#firstName").setValue("");
        $("#lastName").setValue("");
        $("#userEmail").setValue("");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--018").click();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("bug.png");
        $("#currentAddress").setValue("");
        $("#submit").click();

        $(".table-responsive").shouldBe(hidden);
    }
}
