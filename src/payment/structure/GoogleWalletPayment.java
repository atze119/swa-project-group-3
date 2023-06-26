package payment.structure;

public class GoogleWalletPayment extends Payment {
    @Override
    protected void currencyAmountFromSenderToReceiver() {
        System.out.println("The amount was transferred from the sender to the receiver using Google Wallet");
    }
}
