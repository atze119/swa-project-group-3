package content.behaviour;

import booking.behaviour.BookingService;
import booking.structure.Booking;
import content.structure.Content;
import content.structure.SummaryFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
    private InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        contentService = new ContentService();
        bookingService = new BookingService();
        paymentService = new PaymentService();
        naturalPerson = new NaturalPerson("Max", "Mustermann", true, true);
        resource = new ChildSeat(new RoofBox(new Car()));
        String userInput = "G";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        bookingDummy = bookingService.createBooking(naturalPerson, resource);
        userInput = "1";
        in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
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
    void testPrintStructure() {
        String expectedStructure = String.format("""
                - Folder: Content
                  - Folder: Booking
                    - Folder: Year 2023
                      - Folder: Month %1$d
                        - File: Booking-%2$d: Date: %1$d.2023 Amount: 230
                  - Folder: Payment
                    - Folder: Year 2023
                      - Folder: Month %1$d
                        - File: Payment-%3$d: Date: %1$d.2023 Amount: 230
                  - File: Summary
                    Booking-%2$d: Date: %1$d.2023 Booking-Costs: 230
                    Payment-%3$d: Date: %1$d.2023 Transfer-Amount: 230
                                              Total-Amount: 230
                                              """, paymentDummy.getPaymentMonth(), bookingDummy.getBookingId(), paymentDummy.getPaymentId()); // %1$d is the index for index 1 = month $d for number placeholder. Needed because we use random Month
        contentService.addContent(bookingDummy, paymentDummy);
        Assertions.assertEquals(expectedStructure, contentService.printStructure());
    }

    @Test
    void testAddContent() {
       Content content = contentService.addContent(bookingDummy, paymentDummy);
        SummaryFile summaryFile = (SummaryFile) content;
        System.out.println(summaryFile.getTotalPaymentAmount());
        Assertions.assertEquals(summaryFile.getTotalPaymentAmount(), 230);
    }


    @Test
    void testWithNoBooking() {
        Assertions.assertThrows(NullPointerException.class, () -> contentService.addContent(null, paymentDummy));
    }

    @Test
    void testWithNoPayment() {
        Assertions.assertThrows(NullPointerException.class, () -> contentService.addContent(bookingDummy, null));
    }
}