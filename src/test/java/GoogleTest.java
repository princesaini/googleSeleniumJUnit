import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    ChromeDriver driver;

    @BeforeEach
    public void initializeWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Checking Google Homepage")
    public void checkTitle() {
        driver.get("https://www.google.com");
        String expected = "Google";
        String actual = driver.getTitle();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"selenium", "junit", "maven"})
    @DisplayName("quering some words and then cehcking page title")
    public void searchQuery(String query) {
        driver.get("https://www.google.com");

        driver.findElement(By.id("APjFqb")).sendKeys(query, Keys.ENTER);

        String expected = query + " - Google Search";
        String actual = driver.getTitle();
        assertEquals(expected, actual);
    }

    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}
