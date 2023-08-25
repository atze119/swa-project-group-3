import authentification.behaviour.AuthenticationService;
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
        PaymentService paymentService;
        Payment payment;
        for(int i = 0; i<5;i++) {
            //Scanner sc = new Scanner(System.in);
            //PersonService personService = new PersonService(); when static stays
            Person person = PersonService.createPerson();
            AuthenticationService authenticationService = new AuthenticationService();
            authenticationService.authenticateSubject(person);

            ResourceService resourceService = new ResourceService();
            Resource resource = resourceService.getSelectedResource();

            BookingService bookingService = new BookingService();
            Booking booking = bookingService.createBooking(person, resource);

            paymentService = new PaymentService();
            payment = paymentService.payAmount(booking, person);

            contentService.addContent(booking, payment);
            contentService.printStructure();

            payment.accept(visitor);

        }

    }
}