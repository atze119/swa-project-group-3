package booking.behaviour;

import booking.structure.Booking;
import booking.structure.BookingBuilder;
import booking.structure.EnglishBooking;
import booking.structure.GermanBooking;
import person.structure.Person;
import resource.structure.Resource;

import java.util.Scanner;

public class BookingService {

    public Booking createBooking(Person person, Resource resource) { // TODO person and resource parameters to put them in the booking head/body/footer
        Booking booking;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to get your booking in german or english? Input 'german' or 'english'");
        if (sc.next().equals("german")) {

            GermanBooking germanBooking = new BookingBuilder()
                    .head(person.getName()) // maybe input Person.getName
                    .body(resource.getResource()) // TODO resources are in english
                    .footer(resource.getCosts()) // something
                    .buildGerman();
            germanBooking.printBooking();
            booking = germanBooking;
        } else {
            EnglishBooking englishBooking = new BookingBuilder()
                    .head(person.getName())
                    .body(resource.getResource())
                    .footer(resource.getCosts())
                    .buildEnglish();
            englishBooking.printBooking();
            booking = englishBooking;
        }
        return booking;                 //return booking --> payment needs booking values
    }
}
