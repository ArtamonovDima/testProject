package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String mainPageUrl = "https://football.ua";

    //laizy initialization (like PageFactory)
    private final SelenideElement searchField = $(By.xpath("//div[@class = 'header-search']//input[@type = 'text']"));
    private final SelenideElement consentButton = $(By.xpath("//p[text() = 'Consent']"));

    public void openMainPage() {
        open(mainPageUrl);
    }

    public void search(String searchText) {
        consentButton.shouldBe(Condition.clickable).click();
        searchField.shouldBe(Condition.visible).setValue(searchText);
        searchField.pressEnter();
    }
}
