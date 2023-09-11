package booking.behaviour;

import booking.structure.Booking;
import org.junit.jupiter.api.AfterEach;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookingServiceTest {
    private Person naturalPerson;
    private Person legalPerson;
    private Resource resource;
    private BookingService bookingService;
    private static InputStream sysInBackup;
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
    void createGermanBooking() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(naturalPerson, resource);
        assertNotNull(booking);
    }

    @Test
    void createEnglishBooking() {
        String userInput = "E";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(naturalPerson, resource);
        assertNotNull(booking);
    }

    @Test
    void createLegalPersonEnglishBooking() {
        String userInput = "E";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(legalPerson, resource);
        assertNotNull(booking);
    }

    @Test
    void createLegalPersonGermanBooking() {
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Booking booking = bookingService.createBooking(legalPerson, resource);
        assertNotNull(booking);
    }
}