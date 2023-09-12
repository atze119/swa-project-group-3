package statistics.structure;

import booking.structure.EnglishBooking;
import booking.structure.GermanBooking;
import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;

public class StatisticsVisitor implements Visitor {

    public int englishBookingsPaidByPayPalCount = 0;
    public int germanBookingsPaidByPayPalCount = 0;
    public int englishBookingPaidByMobileWalletCount = 0;
    public int germanBookingPaidByMobileWalletCount = 0;
    public int germanBookingPaidByGoogleWalletCount = 0;
    public int englishBookingPaidByGoogleWalletCount = 0;

    @Override
    public void visit(EnglishBooking booking, PayPalPayment payment) {
        englishBookingsPaidByPayPalCount++;
    }

    @Override
    public void visit(GermanBooking booking, PayPalPayment payment) {
        germanBookingsPaidByPayPalCount++;
    }

    @Override
    public void visit(EnglishBooking booking, MobileMoneyWalletPayment payment) {
        englishBookingPaidByMobileWalletCount++;
    }

    @Override
    public void visit(GermanBooking booking, MobileMoneyWalletPayment payment) {
        germanBookingPaidByMobileWalletCount++;
    }

    @Override
    public void visit(EnglishBooking booking, GoogleWalletPayment payment) {
        englishBookingPaidByGoogleWalletCount++;
    }

    @Override
    public void visit(GermanBooking booking, GoogleWalletPayment payment) {
        germanBookingPaidByGoogleWalletCount++;
    }

//    public void printStatistics() {
//        if (englishBookingsPaidByPayPalCount > 0) {
//            System.out.println("PayPal wurde " + englishBookingsPaidByPayPalCount + " mal in englischen Buchungen benutzt.");
//        }
//        if (germanBookingsPaidByPayPalCount > 0) {
//            System.out.println("PayPal wurde " + germanBookingsPaidByPayPalCount + " mal in deutschen Buchungen benutzt.");
//        }
//        if (englishBookingPaidByMobileWalletCount > 0) {
//            System.out.println("Mobile Money Wallet wurde " + englishBookingPaidByMobileWalletCount + " mal in englischen Buchungen benutzt.");
//        }
//        if (germanBookingPaidByMobileWalletCount > 0) {
//            System.out.println("Mobile Money Wallet wurde " + germanBookingPaidByMobileWalletCount + " mal in deutschen Buchungen benutzt.");
//        }
//        if (englishBookingPaidByGoogleWalletCount > 0) {
//            System.out.println("Google Wallet wurde " + englishBookingPaidByGoogleWalletCount + " mal in englischen Buchungen benutzt.");
//        }
//        if (germanBookingPaidByGoogleWalletCount > 0) {
//            System.out.println("Google Wallet wurde " + germanBookingPaidByGoogleWalletCount + " mal in deutschen Buchungen benutzt.");
//        }
//    }
}