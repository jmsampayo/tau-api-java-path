package taudemo;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.*;

@TestInstance(Lifecycle.PER_CLASS)

public class SeleniumTest {
    private BrowserGetter browserGetter = new BrowserGetter();
    private WebDriver webDriver;

    @BeforeAll
    public void beforeAll() {
        webDriver = browserGetter.getChromeDriver();
    }

    @AfterAll
    public void afterAll() {
        webDriver.quit();
    }

    @Test
    public void pageTitleIsCorrect () {
        String expectedTitle = "Example Domain";
        webDriver.get("https://www.example.com/");
        assertEquals(expectedTitle, webDriver.getTitle());
    }
}
