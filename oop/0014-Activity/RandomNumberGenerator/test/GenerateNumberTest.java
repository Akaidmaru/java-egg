import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateNumberTest {

    @RepeatedTest(25)
    void randomNumberTest() {
        int randomNumber = randomNumber();
        assertTrue(randomNumber > =13 && randomNumber <= 35)
    }
}