import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenerateNumberTest {

    @Test
    void randomNumberTest() {
        GenerateNumber randomNumber = new GenerateNumber();
        int number = randomNumber.randomNumber();
        assertTrue(number >= 1 && number <= 355, "El número debe estar en este rango.");
    }
}