package ui.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private final SelenideElement searchedText = $(By.xpath("//*[contains (text(), 'Arsenal Football Club')]"));

    public String getSearchedText() {
        return searchedText.getText();
    }
}
