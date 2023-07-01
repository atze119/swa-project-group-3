package payment.structure;

import booking.structure.Booking;
import person.structure.Person;

import java.util.Date;

public abstract class Payment{

    private int transferAmount;
    private int paymentMonth;
    private int paymentYear;

    private int paymentId;
    public void processPayment(Account senderAccount, Account receiverAccount, Booking booking){
        this.paymentMonth = booking.randomBookingMonth();
        this.paymentYear = 2023;
        this.paymentId = IdGenerator.getNextId();
        authenticateSenderAccount(senderAccount, receiverAccount, booking);
        currencyAmountFromSenderToReceiver(senderAccount, receiverAccount, booking);
        createPaymentConfirmation(senderAccount, receiverAccount);
    }

    private void authenticateSenderAccount(Account senderAccount, Account receiverAccount, Booking booking) {

        this.transferAmount = booking.getCosts();
        int currentSenderBalance = senderAccount.getCurrencyAmount().getAmount();
        int currentReceiverBalance = receiverAccount.getCurrencyAmount().getAmount();

        System.out.printf("""
                %s has authenticated with the payment service provider
                The transfer Amount is: %d
                The current account balance from the sender (%s) is: %d
                The current account balance from the receiver (%s) is: %d
                %n""",senderAccount.getName(),transferAmount,senderAccount.getName(),currentSenderBalance,receiverAccount.getName(),currentReceiverBalance);
    }

    protected abstract void currencyAmountFromSenderToReceiver(Account senderAccount, Account receiverAccount, Booking booking);

    private void createPaymentConfirmation(Account senderAccount, Account receiverAccount) {

        int currentSenderBalance = senderAccount.getCurrencyAmount().getAmount();
        int currentReceiverBalance = receiverAccount.getCurrencyAmount().getAmount();

        System.out.printf("""
                This is your payment confirmation:
                The payment has been successful!
                The new account balance from the sender (%s) is: %d
                The new account balance from the receiver (%s) is: %d
                %n""",senderAccount.getName(),currentSenderBalance,receiverAccount.getName(),currentReceiverBalance);
    }

    public int getTransferAmount() {
        return transferAmount;
    }
    public int getPaymentMonth() {
        return paymentMonth;
    }
    public int getPaymentYear() {
        return paymentYear;
    }
    public int getPaymentId(){return paymentId;}
}
