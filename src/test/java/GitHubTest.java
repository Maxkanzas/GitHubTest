import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {
    @BeforeAll
    public static void beforeAll()
    {
        Configuration.baseUrl = "https://github.com"; // открываем страницу Selenide в GitHub (абсолютный путь)
        Configuration.pageLoadStrategy = "eager"; // команда для того, чтобы селенид не ждал загрузки всех картинок и тяжелых элементов. Только html.
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillTests() {
        open("/enterprise"); // открываем страницу Selenide в GitHub (относительный путь)
//        executeJavaScript("$('#fixedban').remove()"); //убрать окна и баннеры
//        executeJavaScript("$('footer').remove()"); //убрать окна и баннеры
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $("div ul").$(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}