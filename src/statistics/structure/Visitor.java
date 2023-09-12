package statistics.structure;

import booking.structure.EnglishBooking;
import booking.structure.GermanBooking;
import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;

public interface Visitor {
    void visit(EnglishBooking booking, PayPalPayment payment);
    void visit(GermanBooking booking, PayPalPayment payment);

    void visit(EnglishBooking booking, MobileMoneyWalletPayment payment);
    void visit(GermanBooking booking, MobileMoneyWalletPayment payment);

    void visit(EnglishBooking booking, GoogleWalletPayment payment);
    void visit(GermanBooking booking, GoogleWalletPayment payment);

}