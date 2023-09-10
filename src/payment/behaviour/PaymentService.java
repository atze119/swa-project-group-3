package payment.behaviour;

import booking.structure.Booking;
import payment.structure.*;
import person.structure.Person;


import java.util.Scanner;

public class PaymentService {

    private static CurrencyAmount currencyAmountReceiver = new CurrencyAmount(0);

    public Payment payAmount(Booking booking, Person person){

        CurrencyAmount currencyAmountSender = new CurrencyAmount(booking.getCosts());
        Account senderAccount = new Account(currencyAmountSender, person.getName());
        Account receiverAccount = new Account(currencyAmountReceiver,"CarReservationSystem");
        Payment payment = null;

        System.out.println("""
                Which payment method do you want to use? Choose between:
                Google Wallet: 1
                Mobile Money Wallet: 2
                PayPal: 3
                """);
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            String userInput = sc.next();
            if (!userInput.matches("1|2|3")) {
                System.out.println("Please input a valid number between 1 and 3!");
            } else {
                int inputParse = Integer.parseInt(userInput);
                PaymentType paymentType = switch(inputParse){
                    case 1 -> PaymentType.GOOGLE_WALLET;
                    case 2 -> PaymentType.MOBILE_MONEY_WALLET;
                    case 3 -> PaymentType.PAYPAL;
                    default -> throw new IllegalStateException("Unexpected value: " + userInput);
                };

                payment = switch(paymentType){
                    case GOOGLE_WALLET -> new GoogleWalletPayment();
                    case MOBILE_MONEY_WALLET -> new MobileMoneyWalletPayment();
                    case PAYPAL -> new PayPalPayment();
                };
                validInput = true;
            }
        }
        payment.processPayment(senderAccount,receiverAccount,booking);
        return payment;
    }

}
