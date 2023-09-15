package statistics.behavior;

import statistics.structure.StatisticsVisitor;

public class StatisticsService{

    private int getEnglishBookingsPaidByPayPal(StatisticsVisitor visitor) {
        return visitor.englishBookingsPaidByPayPalCount;
    }


    private int getGermanBookingsPaidByPayPal(StatisticsVisitor visitor) {
        return visitor.germanBookingsPaidByPayPalCount;
    }


    private int getEnglishBookingsPaidByGoogleWallet(StatisticsVisitor visitor) {
        return visitor.englishBookingPaidByGoogleWalletCount;
    }


    private int getGermanBookingsPaidByGoogleWallet(StatisticsVisitor visitor) {
        return visitor.germanBookingPaidByGoogleWalletCount;
    }


    private int getEnglishBookingsPaidByMobileMoneyWallet(StatisticsVisitor visitor) {
        return visitor.englishBookingPaidByMobileWalletCount;
    }


    private int getGermanBookingsPaidByMobileMoneyWallet(StatisticsVisitor visitor) {
        return visitor.germanBookingPaidByMobileWalletCount;
    }


    public void printStatistics(StatisticsVisitor visitor) {
        System.out.println("PayPal was used " + getEnglishBookingsPaidByPayPal(visitor) + " times in english bookings.");
        System.out.println("PayPal was used " + getGermanBookingsPaidByPayPal(visitor) + " times in german bookings.");
        System.out.println("Mobile Money Wallet was used " + getEnglishBookingsPaidByMobileMoneyWallet(visitor) + " times in english bookings.");
        System.out.println("Mobile Money Wallet was used " + getGermanBookingsPaidByMobileMoneyWallet(visitor) + " times in german bookings.");
        System.out.println("Google Wallet was used " + getEnglishBookingsPaidByGoogleWallet(visitor) + " times in english bookings.");
        System.out.println("Google Wallet was used " + getGermanBookingsPaidByGoogleWallet(visitor) + " times in german bookings.");
    }

}

