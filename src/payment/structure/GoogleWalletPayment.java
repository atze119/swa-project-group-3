package payment.structure;

import booking.structure.Booking;
import statistics.structure.Visitor;

public class GoogleWalletPayment extends Payment {

    //TODO visitor pattern changes in line 10-12
    public void accept(Visitor visitor) {
        visitor.visitGoogleWallet(this);
    }
    @Override
    protected void currencyAmountFromSenderToReceiver(Account senderAccount, Account receiverAccount, Booking booking) {
        int transferAmount = booking.getCosts();
        int senderBalanceOld = senderAccount.getCurrencyAmount().getAmount();
        int receiverBalanceOld = receiverAccount.getCurrencyAmount().getAmount();

        if(senderBalanceOld >= transferAmount) {
            senderAccount.getCurrencyAmount().setAmount(senderBalanceOld-transferAmount);
            receiverAccount.getCurrencyAmount().setAmount(receiverBalanceOld+transferAmount);
        }
        else {
            throw new IllegalStateException("Sender does not have enough balance for transaction");
        }
        int senderBalanceNew = senderAccount.getCurrencyAmount().getAmount();
        int receiverBalanceNew = receiverAccount.getCurrencyAmount().getAmount();

        System.out.printf("""
                The payment will now be made . . .
                The amount of %d was transferred from the sender account (%s) to the receiver account (%s) using %s
                %n""",transferAmount,senderAccount.getName(),receiverAccount.getName(),GoogleWalletPayment.class.getSimpleName());
    }
}
