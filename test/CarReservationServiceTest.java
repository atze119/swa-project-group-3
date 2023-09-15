import authentication.behaviour.AuthenticationServiceTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//@RunWith(Suite.class)
//@SuiteClasses({ClassATest.class, ClassBTest.class, ClassCTest.class})
class CarReservationServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(sysInBackup);
        System.setOut(originalOut);
    }

    @Test
    void testCarReservationService() {
        String[] args = null;
        String userInput = "N Max Mustermann Y Y Y 2 Y Y Y G 1 N";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        CarReservationService.main(args);
        assertTrue(outContent.toString().contains("Google Wallet was used 1 times in german bookings."));
    }
    @Test
    void testCarReservationServiceComplete() {
        AuthenticationServiceTest authenticationServiceTest = new AuthenticationServiceTest();
        authenticationServiceTest.testAuthenticateLegalSubject();
        authenticationServiceTest.testAuthenticateLegalSubject();
    }
}