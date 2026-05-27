package ui.service;

import ui.page.MainPage;
import ui.page.SearchResultPage;

public class SearchService {

    private final MainPage page = new MainPage();

    public SearchResultPage goToMainPageAndSearch(String searchText) {
        page.openMainPage();
        page.search(searchText);
        return new SearchResultPage();
    }
}
