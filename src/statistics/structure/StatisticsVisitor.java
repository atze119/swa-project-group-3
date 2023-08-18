package statistics.structure;

import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;

public class StatisticsVisitor implements Visitor {
    @Override
    public void visit(PayPalPayment paypalPayment) {
        //TODO implement logic for statistics of paypal payments
    }

    @Override
    public void visit(GoogleWalletPayment googleWalletPayment) {
        //TODO implement logic for statistics of google wallet payments
    }

    @Override
    public void visit(MobileMoneyWalletPayment moneyWalletPayment) {
        //TODO implement logic for statistics of money wallet payments
    }
}
