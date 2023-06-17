import booking.behaviour.BookingService;

public class Main {
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        bookingService.createBooking();
        System.out.println("Hello world!");
    }
}