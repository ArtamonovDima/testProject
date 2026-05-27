package ui.base;

import com.codeborne.selenide.Configuration;

public class BaseTest {

    static {
        Configuration.browser = "chrome";
        Configuration.headless = false;
    }
}
