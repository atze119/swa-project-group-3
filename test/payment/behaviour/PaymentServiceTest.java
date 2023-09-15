package payment.behaviour;

import booking.behaviour.BookingService;
import booking.structure.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.structure.GoogleWalletPayment;
import payment.structure.MobileMoneyWalletPayment;
import payment.structure.PayPalPayment;
import payment.structure.Payment;
import person.structure.NaturalPerson;
import resource.structure.Car;
import resource.structure.ChildSeat;
import resource.structure.Resource;
import resource.structure.RoofBox;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class PaymentServiceTest {

    private static InputStream sysInBackup;
    private BookingService bookingService;
    private NaturalPerson naturalPerson;
    private Booking bookingDummy;
    private Resource resource;
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
        paymentService = new PaymentService();
        naturalPerson = new NaturalPerson("Max", "Mustermann", true, true);
        resource = new ChildSeat(new RoofBox(new Car()));
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        bookingDummy = bookingService.createBooking(naturalPerson, resource, new Scanner(System.in));
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        bookingService = null;
        naturalPerson = null;
        resource = null;
        bookingDummy = null;
        paymentService = null;
        System.setIn(sysInBackup);
    }

    @Test
    void testGoogleWallet() {
        String userInput = "1";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Payment payment = paymentService.payAmount(bookingDummy, naturalPerson, new Scanner(System.in));
        Assertions.assertTrue(payment instanceof GoogleWalletPayment);
    }

    @Test
    void testMobileMoneyWallet() {
        String userInput = "2";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Payment payment = paymentService.payAmount(bookingDummy, naturalPerson, new Scanner(System.in));
        Assertions.assertTrue(payment instanceof MobileMoneyWalletPayment);
    }

    @Test
    void testPaypal() {
        String userInput = "3";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Payment payment = paymentService.payAmount(bookingDummy, naturalPerson, new Scanner(System.in));
        Assertions.assertTrue(payment instanceof PayPalPayment);
    }



}