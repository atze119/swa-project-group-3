import authentication.behaviour.AuthenticationService;
import booking.behaviour.BookingService;
import booking.structure.Booking;
import content.behaviour.ContentService;
import payment.behaviour.PaymentService;
import payment.structure.Payment;
import person.behaviour.PersonService;
import person.structure.Person;
import resource.behaviour.ResourceService;
import resource.structure.Resource;
import statistics.structure.StatisticsVisitor;

public class Main {
    public static void main(String[] args) {
        ContentService contentService = new ContentService();
        StatisticsVisitor visitor = new StatisticsVisitor();
        AuthenticationService authenticationService;
        BookingService bookingService;
        Booking booking;
        ResourceService resourceService;
        Resource resource;
        PaymentService paymentService;
        Payment payment;
        for(int i = 0; i<5;i++) {
            //Scanner sc = new Scanner(System.in);
            //PersonService personService = new PersonService(); when static stays
            Person person = PersonService.createPerson();
            if (person == null) {
                return;
            }
            authenticationService = new AuthenticationService();
            authenticationService.authenticateSubject(person);

            resourceService = new ResourceService();
            resource = resourceService.getSelectedResource();

            bookingService = new BookingService();
            booking = bookingService.createBooking(person, resource);

            paymentService = new PaymentService();
            payment = paymentService.payAmount(booking, person);

            contentService.addContent(booking, payment);
            contentService.printStructure();

            payment.accept(visitor);
        //TODO schleife zu while schleife und per abfrage am Ende Möglichkeit zum Ausbruch haben
        }
        //TODO visitor nach ausbruch aus schleife mit allen payment methods
    }
}