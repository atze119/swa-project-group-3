package content.structure;

import booking.structure.Booking;
import payment.structure.Payment;

import java.util.ArrayList;
import java.util.List;

public class SummaryFile extends File{

    private List<Booking> bookings;
    private List<Payment> payments;

    private int fullBookingAmount;
    private int fullPaymentAmount;
    private int sum;

    public SummaryFile(String name) {
        super(name, 0,0);
        this.fullBookingAmount = 0;
        this.fullPaymentAmount = 0;
        this.sum = 0;
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

    @Override
    public void addAmount(int bookingAmount, int paymentAmount){
        this.fullBookingAmount += bookingAmount;
        this.fullPaymentAmount += paymentAmount;
    }

    public void addBookingAmount(int bookingAmount){
        this.fullBookingAmount += bookingAmount;
    }

    public void addPaymentAmount(int paymentAmount){
        this.fullPaymentAmount += paymentAmount;
    }

    public int getFullBookingAmount() {
        return fullBookingAmount;
    }

    public int getFullPaymentAmount() {
        return fullPaymentAmount;
    }

    public int getSum(){
       this.sum = fullBookingAmount - fullPaymentAmount;
       return this.sum;
    }
    @Override
    public String printStructure(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("- File: ").append(name).append("\n");
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            Payment payment = payments.get(i);
            sb.append(prefix).append("  Booking-").append(booking.getBookingId()).append(": Date: ").append(booking.getBookingMonth())
                    .append(".").append(booking.getBookingYear()).append(" Booking-Costs: ").append(booking.getCosts()).append("\n");
            sb.append(prefix).append("  Payment-").append(payment.getPaymentId()).append(": Date: ").append(payment.getPaymentMonth())
                    .append(".").append(payment.getPaymentYear()).append(" Transfer-Amount: ").append(payment.getTransferAmount()).append("\n");
        }
        sb.append(prefix).append("                            ").append("Total-Amount: ").append(fullPaymentAmount);
        return sb.toString();
    }
}


