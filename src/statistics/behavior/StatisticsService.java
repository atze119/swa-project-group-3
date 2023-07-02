package statistics.behavior;

import payment.structure.GoogleWalletPayment;
import payment.structure.PayPalPayment;
import statistics.structure.StatisticsVisitor;
import statistics.structure.Visitor;

public class StatisticsService {
    public void getGermanBookingsPaidByPayPal() {
        // ...
        PayPalPayment paypalPayment = new PayPalPayment();
        Visitor visitor = new StatisticsVisitor();
        paypalPayment.accept(visitor);
        // ...
    }

    public void getGermanBookingsPaidByGoogleWallet() {
        // ...
        GoogleWalletPayment googleWalletPayment = new GoogleWalletPayment();
        Visitor visitor = new StatisticsVisitor();
        googleWalletPayment.accept(visitor);
        // ...
    }

    //TODO Weitere Methoden für andere Kombinationen von Zahlungsmethoden und BookingLanguege
}

