package content.behaviour;

import booking.behaviour.BookingService;
import booking.structure.Booking;
import content.structure.Content;
import content.structure.SummaryFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.behaviour.PaymentService;
import payment.structure.Payment;
import person.structure.NaturalPerson;
import resource.structure.Car;
import resource.structure.ChildSeat;
import resource.structure.Resource;
import resource.structure.RoofBox;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class ContentServiceTest {
    private Booking bookingDummy;
    private BookingService bookingService;
    private NaturalPerson naturalPerson;
    private Resource resource;
    private Payment paymentDummy;
    private PaymentService paymentService;
    private ContentService contentService;
    private static InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        String userInput = "G 1"; // gerade noch der scanner fehler da der sich immer wieder nneu initialisiert in den verschiedneen Methodne
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        contentService = new ContentService();
        bookingService = new BookingService();
        paymentService = new PaymentService();
        naturalPerson = new NaturalPerson("Fynn", "Juranek", true, true);
        resource = new ChildSeat(new RoofBox(new Car()));
        bookingDummy = bookingService.createBooking(naturalPerson, resource);
        paymentDummy = paymentService.payAmount(bookingDummy, naturalPerson);
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        contentService = null;
        bookingService = null;
        paymentService = null;
        naturalPerson = null;
        resource = null;
        bookingDummy = null;
        paymentDummy = null;
        System.setIn(sysInBackup);
    }

    @Test
    void addContent() { //TODO Test schreiben für Methoden getOrCreateFolder, printStructure
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

       Content content = contentService.addContent(bookingDummy, paymentDummy);
        SummaryFile f = (SummaryFile) content;
        System.out.println(f.getTotalPaymentAmount());
//       Assertions.assertEquals();contentService.printStructure();
    }
}