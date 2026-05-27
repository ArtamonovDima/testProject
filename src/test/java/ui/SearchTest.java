package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.service.SearchService;

public class SearchTest {

    private final SearchService service = new SearchService();

    @Test
    void searchTextFromMainPage() {
        var searchResultPage = service.goToMainPageAndSearch("Arsenal");
        Assertions.assertEquals("Arsenal Football Club", searchResultPage.getSearchedText());
    }
}
