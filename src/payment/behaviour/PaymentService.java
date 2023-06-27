package payment.behaviour;

import booking.structure.Booking;
import payment.structure.*;


import java.util.Scanner;

public class PaymentService {

    public Payment payAmount(Booking booking){

        CurrencyAmount currencyAmountSender = new CurrencyAmount(booking.getCosts());
        CurrencyAmount currencyAmountReceiver = new CurrencyAmount(0);
        Account senderAccount = new Account(currencyAmountSender);
        Account receiverAccount = new Account(currencyAmountReceiver);

        System.out.println("""
                Which payment method do you want to use? Choose between:
                Google Wallet: 1
                Mobile Money Wallet: 2
                PayPal: 3
                """);
        Scanner sc = new Scanner(System.in);
        int paymentMethod= sc.nextInt();

        PaymentType paymentType = switch(paymentMethod){
            case 1 -> PaymentType.GOOGLE_WALLET;
            case 2 -> PaymentType.MOBILE_MONEY_WALLET;
            case 3 -> PaymentType.PAYPAL;
            default -> throw new IllegalStateException("Unexpected value: " + paymentMethod);
        };

        Payment payment = switch(paymentType){
            case GOOGLE_WALLET -> new GoogleWalletPayment();
            case MOBILE_MONEY_WALLET -> new MobileMoneyWalletPayment();
            case PAYPAL -> new PayPalPayment();
        };

        payment.processPayment(senderAccount,receiverAccount);
        return payment;
    }

}
