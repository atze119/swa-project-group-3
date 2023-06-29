package booking.behaviour;

import booking.structure.Booking;
import booking.structure.BookingBuilder;
import booking.structure.EnglishBooking;
import booking.structure.GermanBooking;
import person.structure.Person;
import resource.structure.Resource;

import java.util.Scanner;

public class BookingService {

    public Booking createBooking(Person person, Resource resource) {
        Booking booking = null;
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Do you want to get your booking in german or english? German [G] | English [E]");
            String userInput = sc.next();
            if (!userInput.equals("G") && !userInput.equals("E")) {
                System.out.println("Please input a valid character! [Y] | [N]");
            } else if (userInput.equals("G")) {
                GermanBooking germanBooking = new BookingBuilder()
                        .head(person.getName()) // maybe input Person.getName
                        .body(resource.getResource()) // TODO resources are in english
                        .footer(resource.getCosts()) // something
                        .buildGerman();
                germanBooking.printBooking();
                booking = germanBooking;
                validInput = true; // to break out of while loop
            } else {
                EnglishBooking englishBooking = new BookingBuilder()
                        .head(person.getName())
                        .body(resource.getResource())
                        .footer(resource.getCosts())
                        .buildEnglish();
                englishBooking.printBooking();
                booking = englishBooking;
                validInput = true; // to break out of while loop
            }
        }
        return booking;                 //return booking --> payment needs booking values
    }
}
