package booking.structure;

import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;
import payment.structure.Payment;
import statistics.structure.Visitor;

import java.util.Random;

public class GermanBooking implements Booking {
    private final String head, body;
    private final int footer;
    private int bookingMonth;
    private int bookingYear = 2023;

    @Override
    public void accept(Visitor visitor, Payment payment) {
        if (payment instanceof PayPalPayment) {
            visitor.visit(this, (PayPalPayment) payment);
        }
        if (payment instanceof MobileMoneyWalletPayment) {
            visitor.visit(this, (MobileMoneyWalletPayment) payment);
        }
        if (payment instanceof GoogleWalletPayment) {
            visitor.visit(this, (GoogleWalletPayment) payment);
        }
    }
    private int bookingId;
    public GermanBooking(String head, String body, int footer) {
        this.head = head;
        this.body = body;
        this.footer = footer;
        this.bookingId = IdGenerator.getNextId();
    }

    @Override
    public void printBooking() {
        System.out.printf("""
                Rechnung fuer: %s
                Sie haben folgendes gebucht: %s
                Ihre Buchung kostet: %s
                %n""", head, body, footer); // %n  = new line
    }

    @Override
    public int getCosts() {
        return footer;
    }

    public int randomBookingMonth() {
        Random random = new Random();
        this.bookingMonth = random.nextInt(12) + 1;
        return bookingMonth;
    }

    @Override
    public int getBookingId() {
        return this.bookingId;
    }

    @Override
    public int getBookingMonth() {
        return bookingMonth;
    }

    @Override
    public int getBookingYear(){
        return bookingYear;
    }

}
