import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BookingsTest {

    private Bookings booking;

    @BeforeEach
    void setUp() {
        booking = new Bookings("25", "2023-10-10", "Redd");
    }

    @Test
    void testBookingsConstructors() {
        // Success case
        assertDoesNotThrow(() -> new Bookings("25", "2023-10-10", "Redd"));

        Bookings bookings = assertDoesNotThrow(() -> new Bookings("25", "2023-10-10", "Redd"));
        assertNotNull(bookings);

        // Fail Case: Exceptions thrown
        assertThrows(IllegalArgumentException.class, () -> new Bookings("", "2023-10-10", "Redd"));
        assertThrows(IllegalArgumentException.class, () -> new Bookings("25", "", "Redd"));
        assertThrows(IllegalArgumentException.class, () -> new Bookings("25", "2023-10-10", ""));
    }

    @Test
    void setId() {
        // Success case
        assertDoesNotThrow(() -> booking.setId("5"));

        // Fail case
        assertThrows(IllegalArgumentException.class, () -> booking.setId(""));
    }

    @Test
    void setDate() {
        // Success case
        assertDoesNotThrow(() -> booking.setDate("2023-10-10"));

        // Fail case
        assertThrows(IllegalArgumentException.class, () -> booking.setDate(""));
    }

    @Test
    void setBookingName() {
        // Success case
        assertDoesNotThrow(() -> booking.setBookingName("Redd"));

        // Fail case
        assertThrows(IllegalArgumentException.class, () -> booking.setBookingName(""));
    }

    @ParameterizedTest
    @CsvSource({
            "'   john', 'John'",
            "'JANE', 'Jane'",
            "'alice', 'Alice'",
    })
    void normalizeBookingName(String input, String expected) {
        assertEquals(expected, booking.normalizeBookingName(input));
    }

    @Test
    void testToString() {
        String expected = "Bookings{id='25', date='2023-10-10', bookingName='Redd'}";
        assertEquals(expected, booking.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Bookings booking2 = new Bookings("25", "2023-10-11", "Redd");
        Bookings booking3 = new Bookings("26", "2023-10-10", "Redd");

        assertEquals(booking, booking2);
        assertNotEquals(booking, booking3);

        assertEquals(booking.hashCode(), booking2.hashCode());
        assertNotEquals(booking.hashCode(), booking3.hashCode());
    }
}