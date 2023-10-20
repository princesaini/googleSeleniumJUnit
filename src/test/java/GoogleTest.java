import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GoogleTest {
    @Test
    @DisplayName("This is a Sample Test")
    public void sampleTest() {
        String name = "prince";
        assertEquals("prince", name, "Sample Message");
    }
}
