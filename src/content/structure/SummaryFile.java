package content.structure;

import booking.structure.Booking;
import payment.structure.Payment;

import java.util.ArrayList;
import java.util.List;

public class SummaryFile extends File{

    private List<Booking> bookings;
    private List<Payment> payments;

    public SummaryFile(String name) {
        super(name, 0,0);
        bookings = new ArrayList<>();
        payments = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public int getTotalBookingAmount() {
        int total = 0;
        for (Booking booking : bookings) {
            total += booking.getCosts();
        }
        return total;
    }

    public int getTotalPaymentAmount() {
        int total = 0;
        for (Payment payment : payments) {
            total += payment.getTransferAmount();
        }
        return total;
    }
}


