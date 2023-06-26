package payment.structure;

public class PayPalPayment extends Payment {


    @Override
    protected void currencyAmountFromSenderToReceiver() {
        System.out.println("The amount was transferred from the sender to the receiver using PayPal");
    }
}
