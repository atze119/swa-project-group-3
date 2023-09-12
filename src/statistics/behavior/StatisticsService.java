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
        System.out.println("PayPal wurde " + getEnglishBookingsPaidByPayPal(visitor) + " mal in englischen Buchungen benutzt.");

        System.out.println("PayPal wurde " + getGermanBookingsPaidByPayPal(visitor) + " mal in deutschen Buchungen benutzt.");

        System.out.println("Mobile Money Wallet wurde " + getEnglishBookingsPaidByMobileMoneyWallet(visitor) + " mal in englischen Buchungen benutzt.");

        System.out.println("Mobile Money Wallet wurde " + getGermanBookingsPaidByMobileMoneyWallet(visitor) + " mal in deutschen Buchungen benutzt.");

        System.out.println("Google Wallet wurde " + getEnglishBookingsPaidByGoogleWallet(visitor) + " mal in englischen Buchungen benutzt.");

        System.out.println("Google Wallet wurde " + getGermanBookingsPaidByGoogleWallet(visitor) + " mal in deutschen Buchungen benutzt.");

}

}

