package statistics.behaviour;

import booking.structure.EnglishBooking;
import booking.structure.GermanBooking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;
import statistics.behavior.StatisticsService;
import statistics.structure.StatisticsVisitor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsServiceTest {

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    PrintStream old = System.out;

    private StatisticsVisitor visitor;
    private StatisticsService statisticsService;

    @BeforeEach
     void setUp() {
        visitor = new StatisticsVisitor();
        statisticsService = new StatisticsService();
    }

    @AfterEach
    void tearDown() {
        visitor = null;
        statisticsService = null;
    }

    @Test
    public void testPrintStatistics0() {
        String expectedPrint = """
                  PayPal was used 0 times in english bookings.
                  PayPal was used 0 times in german bookings.
                  Mobile Money Wallet was used 0 times in english bookings.
                  Mobile Money Wallet was used 0 times in german bookings.
                  Google Wallet was used 0 times in english bookings.
                  Google Wallet was used 0 times in german bookings.
                  """;

        System.setOut(ps);
        statisticsService.printStatistics(visitor);

        assertEquals(expectedPrint, baos.toString());
        assertEquals(0, visitor.englishBookingsPaidByPayPalCount);
        assertEquals(0, visitor.germanBookingsPaidByPayPalCount);
        assertEquals(0, visitor.englishBookingPaidByMobileWalletCount);
        assertEquals(0, visitor.germanBookingPaidByMobileWalletCount);
        assertEquals(0, visitor.englishBookingPaidByGoogleWalletCount);
        assertEquals(0, visitor.germanBookingPaidByGoogleWalletCount);
    }

    @Test
    public void testPrintStatistics1() {
        EnglishBooking englishBooking1 = new EnglishBooking("Head1", "Body1", 100);
        EnglishBooking englishBooking2 = new EnglishBooking("Head2", "Body2", 200);
        EnglishBooking englishBooking3 = new EnglishBooking("Head3", "Body3", 300);
        GermanBooking germanBooking1 = new GermanBooking("Kopf1", "Körper1", 150);
        GermanBooking germanBooking2 = new GermanBooking("Kopf2", "Körper2", 250);
        GermanBooking germanBooking3 = new GermanBooking("Kopf3", "Körper4", 350);

        englishBooking1.accept(visitor, new PayPalPayment());
        englishBooking2.accept(visitor, new MobileMoneyWalletPayment());
        englishBooking3.accept(visitor, new GoogleWalletPayment());
        germanBooking1.accept(visitor, new PayPalPayment());
        germanBooking2.accept(visitor, new MobileMoneyWalletPayment());
        germanBooking3.accept(visitor, new GoogleWalletPayment());

        String expectedPrint = """
                  PayPal was used 1 times in english bookings.
                  PayPal was used 1 times in german bookings.
                  Mobile Money Wallet was used 1 times in english bookings.
                  Mobile Money Wallet was used 1 times in german bookings.
                  Google Wallet was used 1 times in english bookings.
                  Google Wallet was used 1 times in german bookings.
                  """;

        System.setOut(ps);
        statisticsService.printStatistics(visitor);

        assertEquals(expectedPrint, baos.toString());

        assertEquals(1, visitor.englishBookingsPaidByPayPalCount);
        assertEquals(1, visitor.germanBookingsPaidByPayPalCount);
        assertEquals(1, visitor.englishBookingPaidByMobileWalletCount);
        assertEquals(1, visitor.germanBookingPaidByMobileWalletCount);
        assertEquals(1, visitor.englishBookingPaidByGoogleWalletCount);
        assertEquals(1, visitor.germanBookingPaidByGoogleWalletCount);
    }

    @Test
    public void testPrintStatistics2() {
        EnglishBooking englishBooking1 = new EnglishBooking("Head1", "Body1", 100);
        EnglishBooking englishBooking2 = new EnglishBooking("Head2", "Body2", 200);
        EnglishBooking englishBooking3 = new EnglishBooking("Head3", "Body3", 300);
        EnglishBooking englishBooking4 = new EnglishBooking("Head4", "Body4", 400);
        EnglishBooking englishBooking5 = new EnglishBooking("Head5", "Body5", 500);
        EnglishBooking englishBooking6 = new EnglishBooking("Head6", "Body6", 600);
        GermanBooking germanBooking1 = new GermanBooking("Kopf1", "Körper1", 150);
        GermanBooking germanBooking2 = new GermanBooking("Kopf2", "Körper2", 250);
        GermanBooking germanBooking3 = new GermanBooking("Kopf3", "Körper3", 350);
        GermanBooking germanBooking4 = new GermanBooking("Kopf4", "Körper4", 450);
        GermanBooking germanBooking5 = new GermanBooking("Kopf5", "Körper5", 550);
        GermanBooking germanBooking6 = new GermanBooking("Kopf6", "Körper6", 650);

        englishBooking1.accept(visitor, new PayPalPayment());
        englishBooking2.accept(visitor, new MobileMoneyWalletPayment());
        englishBooking3.accept(visitor, new GoogleWalletPayment());
        englishBooking4.accept(visitor, new PayPalPayment());
        englishBooking5.accept(visitor, new MobileMoneyWalletPayment());
        englishBooking6.accept(visitor, new GoogleWalletPayment());
        germanBooking1.accept(visitor, new PayPalPayment());
        germanBooking2.accept(visitor, new MobileMoneyWalletPayment());
        germanBooking3.accept(visitor, new GoogleWalletPayment());
        germanBooking4.accept(visitor, new PayPalPayment());
        germanBooking5.accept(visitor, new MobileMoneyWalletPayment());
        germanBooking6.accept(visitor, new GoogleWalletPayment());

        String expectedPrint = """
                  PayPal was used 2 times in english bookings.
                  PayPal was used 2 times in german bookings.
                  Mobile Money Wallet was used 2 times in english bookings.
                  Mobile Money Wallet was used 2 times in german bookings.
                  Google Wallet was used 2 times in english bookings.
                  Google Wallet was used 2 times in german bookings.
                  """;

        System.setOut(ps);
        statisticsService.printStatistics(visitor);

        assertEquals(expectedPrint, baos.toString());

        assertEquals(2, visitor.englishBookingsPaidByPayPalCount);
        assertEquals(2, visitor.germanBookingsPaidByPayPalCount);
        assertEquals(2, visitor.englishBookingPaidByMobileWalletCount);
        assertEquals(2, visitor.germanBookingPaidByMobileWalletCount);
        assertEquals(2, visitor.englishBookingPaidByGoogleWalletCount);
        assertEquals(2, visitor.germanBookingPaidByGoogleWalletCount);
    }
}

