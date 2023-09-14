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

class BookingServiceTest {
    private Person naturalPerson;
    private Person legalPerson;
    private Resource resource;
    private BookingService bookingService;
    private InputStream sysInBackup;
    //TODO Test schreiben für createBooking
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
    void createNaturalGermanBooking() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(naturalPerson, resource);
        Assertions.assertNotNull(booking);
    }

    @Test
    void createNaturalEnglishBooking() {
        String userInput = "E";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(naturalPerson, resource);
        Assertions.assertNotNull(booking);
    }

    @Test
    void createLegalPersonEnglishBooking() {
        String userInput = "E";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(legalPerson, resource);
        Assertions.assertNotNull(booking);
    }

    @Test
    void createLegalPersonGermanBooking() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(legalPerson, resource);
        Assertions.assertNotNull(booking);
    }

    @Test
    void createBookingWithoutPerson() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThrows(NullPointerException.class, () -> bookingService.createBooking(null, resource));
    }

    @Test
    void createBookingWithoutResource() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThrows(NullPointerException.class, () -> bookingService.createBooking(naturalPerson, null));
    }
}