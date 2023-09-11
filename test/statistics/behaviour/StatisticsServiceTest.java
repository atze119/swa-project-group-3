package statistics.behaviour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.structure.GoogleWalletPayment;
import payment.structure.PayPalPayment;
import statistics.behavior.StatisticsService;
import statistics.structure.StatisticsVisitor;
import statistics.structure.Visitor;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//TODO write Test
public class StatisticsServiceTest {

    private StatisticsService statisticsService;
    private Visitor visitor;
    @BeforeEach
    public void setUP() {
        statisticsService = new StatisticsService();
        visitor = new StatisticsVisitor();
    }

    @AfterEach
    void tearDown() {
        statisticsService = null;
        visitor = null;
    }
    @Test
    public void testGetGermanBookingsPaidByPayPal() {
        PayPalPayment paypalPayment = new PayPalPayment();
        paypalPayment.accept(visitor);
        statisticsService.getGermanBookingsPaidByPayPal();

        //int count = visitor.getPayPalStatistics; //Annahme: getPayPalStatistics gibt die Anzahl der PayPal-Zahlungen zurück
        // Assert
        //int expectedCount = 5; // Erwartete Anzahl von PayPal-Zahlungen
        //assertEquals(expectedCount, count);
    }

    @Test
    public void testGetGermanBookingsPaidByGoogleWallet() {
        GoogleWalletPayment googleWalletPayment  = new GoogleWalletPayment();
        googleWalletPayment.accept(visitor);
        statisticsService.getGermanBookingsPaidByGoogleWallet();
        //int count = visitor.getGoogleWalletStatistics(); //Annahme: getGoogleWalletStatistics gibt die Anzahl der Google Wallet-Zahlungen zurück
        // Assert
        //int expectedCount = 3; // Erwartete Anzahl von Google Wallet-Zahlungen
        //assertEquals(expectedCount, count);
    }

    // Weitere Tests für andere Kombinationen von Zahlungsmethoden und Buchungen
}
