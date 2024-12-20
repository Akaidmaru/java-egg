import java.util.HashMap;
import java.util.Map;

public class BookingsSystemManagement {
    Map<String, Bookings> bookingsMap;

    public BookingsSystemManagement() {
        this.bookingsMap = new HashMap<>();
    }

    public String addBooking(Bookings bookings) {
        if (bookingsMap.containsKey(bookings.getId()))
            return "Booking with ID " + bookings.getId() + " already exists!";
        String bookingMapId = bookings.getId();
        bookingsMap.put(bookingMapId, bookings);
        return bookingMapId + " has been booked!";
    }

    public String getBooking(String bookingMapId) {
        if (!bookingsMap.containsKey(bookingMapId)) return "Booking doesn't exist.";
        return bookingsMap.get(bookingMapId).toString();
    }

    public String deleteBooking(String bookingMapId) {
        if (!bookingsMap.containsKey(bookingMapId)) return "Booking doesn't exist.";
        Bookings removedBooking = bookingsMap.remove(bookingMapId);
        return String.format("Booking ID %s (%s) has been deleted.",bookingMapId, removedBooking.getBookingName());
    }

    public String getAllBookings() {
        if (bookingsMap.isEmpty()) return "Booking system doesn't have any bookings.";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("*********Bookings (%d)*********%n", bookingsMap.size()));
        for (Map.Entry<String, Bookings> integerBookingsEntry : bookingsMap.entrySet()) {
            stringBuilder.append(String.format("%s ---- %s%n", integerBookingsEntry.getKey(),
                    integerBookingsEntry.getValue()));
        }
        return stringBuilder.toString();
    }

    public String getAllBookingCount() {
        if (bookingsMap.isEmpty()) return "Booking system doesn't have any bookings.";
        return "There are " + bookingsMap.size() + " bookings.";
    }
}
