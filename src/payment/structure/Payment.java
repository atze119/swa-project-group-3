package payment.structure;

public abstract class Payment{

    public void processPayment(Account senderAccount, Account receiverAccount){
        authenticateSenderAccount();
        currencyAmountFromSenderToReceiver(senderAccount, receiverAccount);
        createPaymentConfirmation();
    }

    private void authenticateSenderAccount() {
        System.out.println("You have authenticated yourself with the payment service provider");
    }

    protected abstract void currencyAmountFromSenderToReceiver(Account senderAccount, Account receiverAccount);

    private void createPaymentConfirmation() {
        System.out.println("This is your payment confirmation");
    }


}
