package statistics.structure;

import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;

public interface Visitor {
    void visit(PayPalPayment paypalPayment);
    void visit(GoogleWalletPayment googleWalletPayment);
    void visit(MobileMoneyWalletPayment moneyWalletPayment);

}

