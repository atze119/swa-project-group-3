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
import statistics.behavior.StatisticsService;
import statistics.structure.StatisticsVisitor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContentService contentService = new ContentService();
        StatisticsVisitor visitor = new StatisticsVisitor();
        StatisticsService statistics = new StatisticsService();
        Person person;
        AuthenticationService authenticationService;
        BookingService bookingService;
        Booking booking;
        ResourceService resourceService;
        Resource resource;
        PaymentService paymentService;
        Payment payment;
        carReservation:while(true) {
            person = PersonService.createPerson();
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

            booking.accept(visitor, payment);
            boolean validInput = false;
            System.out.println("Do you want to reservate an other car? Yes [Y] | No [N]");
            while (!validInput) {
                String userInput = sc.next();
                if (!userInput.matches("Y|y|N|n")) {
                    System.out.println("Please input a valid character! [Y] | [N]");
                } else if (userInput.matches("N|n")) {
                    break carReservation;
                } else {
                    validInput = true;
                }
            }
        }
        statistics.printStatistics(visitor);
    }

}