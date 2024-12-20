import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BookingsTest {
    @Test
    void TestBookingsConstructors() {

        // Success case
        assertDoesNotThrow(() -> {
            Bookings booking = new Bookings("25", "10", "R");
        });

        Bookings bookings = assertDoesNotThrow(() -> new Bookings("25", "15", "Re"));
        assertNotNull(bookings);

        // Fail Case: Exceptions thrown
        assertThrows(IllegalArgumentException.class,
                () -> new Bookings("", "10", " R"));
        assertThrows(IllegalArgumentException.class,
                () -> new Bookings("25", "", " R"));
        assertThrows(IllegalArgumentException.class,
                () -> new Bookings("25", "10", " "));
    }

    @Test
    void setId() {
        // Success case
        Bookings booking = new Bookings();
        assertDoesNotThrow(() -> booking.setId("5"));

        // Fail case
        Bookings booking2 = new Bookings();
        assertThrows(IllegalArgumentException.class, () -> booking2.setId(""));
    }

    @Test
    void setDate() {
        // Success case
        Bookings booking = new Bookings();
        assertDoesNotThrow(() -> booking.setDate("10"));

        // Fail case
        Bookings booking2 = new Bookings();
        assertThrows(IllegalArgumentException.class, () -> booking2.setDate(""));
    }

    @Test
    void setBookingName() {
        // Success case
        Bookings booking = new Bookings();
        assertDoesNotThrow(() -> booking.setBookingName("Re"));

        // Fail case
        Bookings booking2 = new Bookings();
        assertThrows(IllegalArgumentException.class, () -> booking2.setBookingName(""));
    }

    @ParameterizedTest
    @CsvSource({
            "'   john', 'John'",
            "'JANE', 'Jane'",
            " 'alice' , 'Alice'",
    })

    void normalizeBookingName(String input, String expected) {
        Bookings booking = new Bookings();
        assertEquals(expected, booking.normalizeBookingName(input));
    }
}