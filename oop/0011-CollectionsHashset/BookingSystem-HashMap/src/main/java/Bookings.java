public class Bookings {
    private String id;
    private String date;
    private String bookingName;

    public Bookings() {
    }

    public Bookings(String id, String date, String bookingName) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID cannot be empty.");
        if (date == null || date.isBlank()) throw new IllegalArgumentException("Date cannot be empty.");
        if (bookingName == null || bookingName.isBlank())
            throw new IllegalArgumentException("Booking name cannot be empty.");

        this.id = id.strip();
        this.date = date.strip();
        this.bookingName = normalizeBookingName(bookingName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID cannot be empty.");
        this.id = id.strip();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date == null || date.isBlank()) throw new IllegalArgumentException("Date cannot be empty.");
        this.date = date.strip();
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        if (bookingName == null || bookingName.isBlank())
            throw new IllegalArgumentException("Booking name cannot be empty.");
        this.bookingName = normalizeBookingName(bookingName);
    }

    public String normalizeBookingName(String name) {
        name = name.strip();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", bookingName='" + bookingName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bookings bookings = (Bookings) o;
        return id.equals(bookings.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
