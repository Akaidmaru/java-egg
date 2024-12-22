import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestReporter; // Hay que importar la interfaz para ver los números generados

import static org.junit.jupiter.api.Assertions.*;

class GenerateNumberTest {

    @RepeatedTest(30)
    void randomNumberTestPositive(TestReporter reporter) {
        int randomNumber = GenerateNumber.randomNumber(13, 35);
        reporter.publishEntry("Número generado: ", String.valueOf(randomNumber)); // Con esto se pueden ver los números generados
        assertTrue(randomNumber >= 13 && randomNumber <= 35);
    }

}