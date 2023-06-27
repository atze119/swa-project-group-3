package payment.structure;

import booking.structure.Booking;

public abstract class Payment{

    public void processPayment(Account senderAccount, Account receiverAccount, Booking booking){
        authenticateSenderAccount(senderAccount, receiverAccount, booking);
        currencyAmountFromSenderToReceiver(senderAccount, receiverAccount, booking);
        createPaymentConfirmation(senderAccount, receiverAccount);
    }

    private void authenticateSenderAccount(Account senderAccount, Account receiverAccount, Booking booking) {

        int transferAmount = booking.getCosts();
        int currentSenderBalance = senderAccount.getCurrencyAmount().getAmount();
        int currentReceiverBalance = receiverAccount.getCurrencyAmount().getAmount();

        System.out.printf("""
                You have authenticated yourself with the payment service provider
                The transfer Amount is: %d
                The current account balance from the sender is: %d
                The current account balance from the receiver is: %d
                %n""",transferAmount,currentSenderBalance,currentReceiverBalance);
    }

    protected abstract void currencyAmountFromSenderToReceiver(Account senderAccount, Account receiverAccount, Booking booking);

    private void createPaymentConfirmation(Account senderAccount, Account receiverAccount) {

        int currentSenderBalance = senderAccount.getCurrencyAmount().getAmount();
        int currentReceiverBalance = receiverAccount.getCurrencyAmount().getAmount();

        System.out.printf("""
                This is your payment confirmation:
                The payment has been successful!
                The new account balance from the sender is: %d
                The new account balance from the receiver is: %d
                %n""",currentSenderBalance,currentReceiverBalance);
    }


}
