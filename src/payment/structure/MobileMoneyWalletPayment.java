package payment.structure;

import booking.structure.Booking;

public class MobileMoneyWalletPayment extends Payment {

    @Override
    protected void currencyAmountFromSenderToReceiver(Account senderAccount, Account receiverAccount, Booking booking) {
        int transferAmount = booking.getCosts();
        int senderBalanceOld = senderAccount.getCurrencyAmount().getAmount();
        int receiverBalanceOld = receiverAccount.getCurrencyAmount().getAmount();

        if(senderBalanceOld >= transferAmount){
            senderAccount.getCurrencyAmount().setAmount(senderBalanceOld-transferAmount);
            receiverAccount.getCurrencyAmount().setAmount(receiverBalanceOld+transferAmount);
        }else{
            throw new IllegalStateException("Sender does not have enough balance for transaction");
        }

        System.out.printf("""
                The payment will now be made . . .
                The amount of %d was transferred from the sender account (%s) to the receiver account (%s) using %s
                %n""",transferAmount,senderAccount.getName(),receiverAccount.getName(),MobileMoneyWalletPayment.class.getSimpleName());
    }
}
