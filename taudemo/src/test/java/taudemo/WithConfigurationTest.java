package taudemo;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.*;

@TestInstance(PER_CLASS)

public class WithConfigurationTest {
    
    private final BrowserGetter browserGetter = new BrowserGetter();
    private WebDriver webDriver;

    @BeforeAll
    public void beforeAll() {
        webDriver = browserGetter.getDriver();
    }

    @AfterAll
    public void afterAll() {
        webDriver.quit();
    }

    @Test
    public void justATest() {
        String expectedTitle = "Example Domain";
        webDriver.get("https://www.example.com");
        assertEquals(expectedTitle, webDriver.getTitle());
    }
}