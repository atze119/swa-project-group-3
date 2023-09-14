package statistics.behaviour;

import booking.structure.EnglishBooking;
import booking.structure.GermanBooking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.structure.GoogleWalletPayment;
import payment.structure.PayPalPayment;
import statistics.behavior.StatisticsService;
import statistics.structure.StatisticsVisitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsServiceTest {

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
    public void testPrintStatistics() {
        EnglishBooking englishBooking1 = new EnglishBooking("Head1", "Body1", 100);
        EnglishBooking englishBooking2 = new EnglishBooking("Head2", "Body2", 200);
        EnglishBooking englishBooking3 = new EnglishBooking("Head2", "Body2", 200);
        GermanBooking germanBooking1 = new GermanBooking("Kopf1", "Körper1", 150);
        GermanBooking germanBooking2 = new GermanBooking("Kopf2", "Körper2", 250);

        englishBooking1.accept(visitor, new PayPalPayment());
        englishBooking2.accept(visitor, new PayPalPayment());
        englishBooking3.accept(visitor, new GoogleWalletPayment());
        germanBooking1.accept(visitor, new PayPalPayment());
        germanBooking2.accept(visitor, new GoogleWalletPayment());

        statisticsService.printStatistics(visitor);

        assertEquals(2, visitor.englishBookingsPaidByPayPalCount);
        assertEquals(1, visitor.germanBookingsPaidByPayPalCount);
        assertEquals(0, visitor.englishBookingPaidByMobileWalletCount);
        assertEquals(0, visitor.germanBookingPaidByMobileWalletCount);
        assertEquals(1, visitor.englishBookingPaidByGoogleWalletCount);
        assertEquals(1, visitor.germanBookingPaidByGoogleWalletCount);
    }
}

