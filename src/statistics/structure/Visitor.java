package statistics.structure;

import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;

public interface Visitor {
    void visitPayPal(PayPalPayment paypalPayment);
    void visitGoogleWallet(GoogleWalletPayment googleWalletPayment);
    void visitMobileMoneyWallet(MobileMoneyWalletPayment moneyWalletPayment);

}

