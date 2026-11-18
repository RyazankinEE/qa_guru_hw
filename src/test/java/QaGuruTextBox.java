import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QaGuruTextBox extends TestBase{

    @Test
    void fullFieldsTextBox(){
        open(QA_GURU);
        $("#userName").setValue("Ivan Ivanov");
        $("#userEmail").setValue("IvanovIvan@mail.ru");
        $("#currentAddress").setValue("Russia");
        $("#permanentAddress").setValue("Moscow");
        $("#submit").click();

        $("#output #name").shouldBe(text("Name:Ivan Ivanov"));
        $("#output #email").shouldBe(text("Email:IvanovIvan@mail.ru"));
        $("#output #currentAddress").shouldBe(text("Current Address :Russia"));
        $("#output #permanentAddress").shouldBe(text("Permananet Address :Moscow"));
    }

    @Test
    void emptyFieldsTextBox(){
        open(QA_GURU);
        $("#userName").setValue("");
        $("#userEmail").setValue("");
        $("#currentAddress").setValue("");
        $("#permanentAddress").setValue("");
        $("#submit").click();

        $("#output #name").shouldBe(text("Name:"));
        $("#output #email").shouldBe(text("Email:"));
        $("#output #currentAddress").shouldBe(text("Current Address :"));
        $("#output #permanentAddress").shouldBe(text("Permananet Address :"));
    }
}
