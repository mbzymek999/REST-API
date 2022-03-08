package demo.domain.values;

import demo.api.exceptions.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTests {

    @Test
    public void testCorrectValues() {
        Assertions.assertDoesNotThrow(() -> {
            new Email("abc@gmail.com");
        });
    }

    @Test
    public void testIncorrectValues() {
        Assertions.assertThrows(BadRequestException.class, () -> new Email("abcmail.com"));
    }
}
