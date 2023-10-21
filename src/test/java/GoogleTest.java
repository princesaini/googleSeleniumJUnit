import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("searching selenium and then cehcking page title")
    public void searchQuery() {
        driver.get("https://www.google.com");

        String query = "selenium";
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
