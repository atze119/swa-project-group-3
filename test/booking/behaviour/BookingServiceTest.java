package booking.behaviour;

import booking.structure.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.structure.LegalPerson;
import person.structure.NaturalPerson;
import person.structure.Person;
import resource.structure.Car;
import resource.structure.ChildSeat;
import resource.structure.Resource;
import resource.structure.RoofBox;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class BookingServiceTest {
    private Person naturalPerson;
    private Person legalPerson;
    private Resource resource;
    private BookingService bookingService;
    private InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        resource = new ChildSeat(new RoofBox(new Car()));
        naturalPerson = new NaturalPerson("Max", "Mustermann", true, true);
        legalPerson = new LegalPerson("Leuphana");
        bookingService = new BookingService();
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        resource = null;
        naturalPerson = null;
        legalPerson = null;
        bookingService = null;
        System.setIn(sysInBackup);
    }

    @Test
    void testCreateNaturalGermanBooking() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(naturalPerson, resource, new Scanner(System.in));
        Assertions.assertNotNull(booking);
    }

    @Test
    void testCreateNaturalEnglishBooking() {
        String userInput = "E";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(naturalPerson, resource, new Scanner(System.in));
        Assertions.assertNotNull(booking);
    }

    @Test
    void testCreateLegalPersonEnglishBooking() {
        String userInput = "E";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(legalPerson, resource, new Scanner(System.in));
        Assertions.assertNotNull(booking);
    }

    @Test
    void testCreateLegalPersonGermanBooking() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(legalPerson, resource, new Scanner(System.in));
        Assertions.assertNotNull(booking);
    }

    @Test
    void testCreateBookingWithoutPerson() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThrows(NullPointerException.class, () -> bookingService.createBooking(null, resource, new Scanner(System.in)));
    }

    @Test
    void testCreateBookingWithoutResource() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThrows(NullPointerException.class, () -> bookingService.createBooking(naturalPerson, null, new Scanner(System.in)));
    }
}