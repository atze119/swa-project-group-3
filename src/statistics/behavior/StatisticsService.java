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
        String result = """
                PayPal was used %d times in english bookings.
                PayPal was used %d times in german bookings.
                Mobile Money Wallet was used %d times in english bookings.
                Mobile Money Wallet was used %d times in german bookings.
                Google Wallet was used %d times in english bookings.
                Google Wallet was used %d times in german bookings.
                """.formatted(getEnglishBookingsPaidByPayPal(visitor),getGermanBookingsPaidByPayPal(visitor), getEnglishBookingsPaidByMobileMoneyWallet(visitor),
                getGermanBookingsPaidByMobileMoneyWallet(visitor), getEnglishBookingsPaidByGoogleWallet(visitor), getGermanBookingsPaidByGoogleWallet(visitor));

        System.out.print(result);
    }

}

