import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static final String QA_GURU = "https://qa-guru.github.io/one-page-form/text-box.html";
    public static final String DEMO_QA = "https://demoqa.com/";

    @BeforeAll
    public static void beforeAll() {
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void afterEach(){
        closeWebDriver();
    }
}
