import org.junit.jupiter.api.Test;
import statistics.behavior.StatisticsService;
import statistics.structure.StatisticsVisitor;
import statistics.structure.Visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsServiceTest {

    @Test
    public void testGetGermanBookingsPaidByPayPal() {
        // Arrange
        StatisticsService statisticsService = new StatisticsService();
        Visitor visitor = new StatisticsVisitor();

        // Act
        statisticsService.getGermanBookingsPaidByPayPal();
        int count = visitor.getPayPalStatistics(); //TODO Annahme: getPayPalStatistics gibt die Anzahl der PayPal-Zahlungen zurück
        // Assert
        int expectedCount = 5; // Erwartete Anzahl von PayPal-Zahlungen
        assertEquals(expectedCount, count);
    }

    @Test
    public void testGetGermanBookingsPaidByGoogleWallet() {
        // Arrange
        StatisticsService statisticsService = new StatisticsService();
        Visitor visitor = new StatisticsVisitor();

        // Act
        statisticsService.getGermanBookingsPaidByGoogleWallet();
        int count = visitor.getGoogleWalletStatistics(); //TODO Annahme: getGoogleWalletStatistics gibt die Anzahl der Google Wallet-Zahlungen zurück
        // Assert
        int expectedCount = 3; // Erwartete Anzahl von Google Wallet-Zahlungen
        assertEquals(expectedCount, count);
    }

    // Weitere Tests für andere Kombinationen von Zahlungsmethoden und Buchungen
}
