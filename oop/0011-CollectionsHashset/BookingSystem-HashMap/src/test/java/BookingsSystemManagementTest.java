import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingsSystemManagementTest {

    private BookingsSystemManagement bookingsSystemManagement;

    @BeforeEach
    void setUp() {
        bookingsSystemManagement = new BookingsSystemManagement();
    }

    @Test
    void addBooking() {
        Bookings booking = new Bookings("1", "2023-10-10", "Redd");
        String result = bookingsSystemManagement.addBooking(booking);
        assertEquals("1 has been booked!", result);

        // Test adding a booking with an existing ID
        String duplicateResult = bookingsSystemManagement.addBooking(booking);
        assertEquals("Booking with ID 1 already exists!", duplicateResult);
    }

    @Test
    void getBooking() {
        Bookings booking = new Bookings("1", "2023-10-10", "Redd");
        bookingsSystemManagement.addBooking(booking);

        String result = bookingsSystemManagement.getBooking("1");
        assertEquals(booking.toString(), result);

        // Test getting a non-existent booking
        String nonExistentResult = bookingsSystemManagement.getBooking("2");
        assertEquals("Booking doesn't exist.", nonExistentResult);
    }

    @Test
    void deleteBooking() {
        Bookings booking = new Bookings("1", "2023-10-10", "Redd");
        bookingsSystemManagement.addBooking(booking);

        String result = bookingsSystemManagement.deleteBooking("1");
        assertEquals("Booking ID 1 (Redd) has been deleted.", result);

        // Test deleting a non-existent booking
        String nonExistentResult = bookingsSystemManagement.deleteBooking("2");
        assertEquals("Booking doesn't exist.", nonExistentResult);
    }

    @Test
    void getAllBookings() {
        Bookings booking1 = new Bookings("1", "2023-10-10", "Redd");
        Bookings booking2 = new Bookings("2", "2023-10-11", "Mar");
        bookingsSystemManagement.addBooking(booking1);
        bookingsSystemManagement.addBooking(booking2);

        String result = bookingsSystemManagement.getAllBookings();
        assertTrue(result.contains("*********Bookings (2)*********"));
        assertTrue(result.contains("1 ---- " + booking1.toString()));
        assertTrue(result.contains("2 ---- " + booking2.toString()));

        // Test getting all bookings when there are no bookings
        bookingsSystemManagement = new BookingsSystemManagement();
        String emptyResult = bookingsSystemManagement.getAllBookings();
        assertEquals("Booking system doesn't have any bookings.", emptyResult);
    }

    @Test
    void getAllBookingCount() {
        Bookings booking1 = new Bookings("1", "2023-10-10", "Redd");
        Bookings booking2 = new Bookings("2", "2023-10-11", "Mar");
        bookingsSystemManagement.addBooking(booking1);
        bookingsSystemManagement.addBooking(booking2);

        String result = bookingsSystemManagement.getAllBookingCount();
        assertEquals("There are 2 bookings.", result);

        // Test getting booking count when there are no bookings
        bookingsSystemManagement = new BookingsSystemManagement();
        String emptyResult = bookingsSystemManagement.getAllBookingCount();
        assertEquals("Booking system doesn't have any bookings.", emptyResult);
    }
}