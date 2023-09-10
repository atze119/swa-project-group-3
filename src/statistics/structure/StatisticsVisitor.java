package statistics.structure;

import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;

public class StatisticsVisitor implements Visitor {

    int pPCounter;
    int gWCounter;
    int mMWCounter;
    //public void printPaymentStatistic(List<Payment> payments) {
    //    for (Payment payment : payments) {
    //        payment.accept(this);
    //    }
    //}
    @Override
    public void visitPayPal(PayPalPayment paypalPayment) {
        pPCounter = pPCounter + 1;
        System.out.println("PayPal wurde " + pPCounter + " mal benutzt.");
    }

    @Override
    public void visitGoogleWallet(GoogleWalletPayment googleWalletPayment) {
        gWCounter = gWCounter + 1;
        System.out.println("GoogleWalet wurde " + gWCounter + " mal benutzt.");
    }

    @Override
    public void visitMobileMoneyWallet(MobileMoneyWalletPayment moneyWalletPayment) {
        mMWCounter = mMWCounter + 1;
        System.out.println("MobileMoneyWallet wurde " + mMWCounter + " mal benutzt.");
    }

//    @Override
//    public void visitEnglishPayPal(PayPalPayment paypalPayment) {
//        pPCounter = pPCounter + 1;
//        System.out.println("PayPal wurde " + pPCounter + " mal benutzt.");
//    }
//
//    @Override
//    public void visitEnglishGoogleWallet(GoogleWalletPayment googleWalletPayment) {
//        gWCounter = gWCounter + 1;
//        System.out.println("GoogleWalet wurde " + gWCounter + " mal benutzt.");
//    }
//
//    @Override
//    public void visitEnglishMobileMoneyWallet(MobileMoneyWalletPayment moneyWalletPayment) {
//        mMWCounter = mMWCounter + 1;
//        System.out.println("MobileMoneyWallet wurde " + mMWCounter + " mal benutzt.");
//    }
}
