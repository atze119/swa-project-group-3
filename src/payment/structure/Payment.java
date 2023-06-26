package payment.structure;

public abstract class Payment{

    public void processPayment(){
        authenticateSenderAccount();
        currencyAmountFromSenderToReceiver();
        createPaymentConfirmation();
    }

    private void authenticateSenderAccount() {
        System.out.println("You have authenticated yourself with the payment service provider");
    }

    protected abstract void currencyAmountFromSenderToReceiver();

    private void createPaymentConfirmation() {
        System.out.println("This is your payment confirmation");
    }


}
