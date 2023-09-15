package booking.behaviour;

import booking.structure.Booking;
import booking.structure.BookingBuilder;
import booking.structure.EnglishBooking;
import booking.structure.GermanBooking;
import person.structure.Person;
import resource.structure.Resource;

import java.util.Scanner;

public class BookingService {

    public Booking createBooking(Person person, Resource resource, Scanner sc) {
        Booking booking = null;
        boolean validInput = false;
        System.out.println("Do you want to get your invoice in german or english? German [G] | English [E]");
        while (!validInput) {
            String userInput = sc.next();
            if (!userInput.matches("G|g|E|e")) {
                System.out.println("Please input a valid character! [G] | [E]");
            } else if (userInput.matches("G|g")) {
                GermanBooking germanBooking = new BookingBuilder()
                        .head(person.getName())
                        .body(resource.getGermanResource())
                        .footer(resource.getCosts())
                        .buildGerman();
                germanBooking.printBooking();
                booking = germanBooking;
                validInput = true;
            } else {
                EnglishBooking englishBooking = new BookingBuilder()
                        .head(person.getName())
                        .body(resource.getEnglishResource())
                        .footer(resource.getCosts())
                        .buildEnglish();
                englishBooking.printBooking();
                booking = englishBooking;
                validInput = true;
            }
        }
        return booking;
    }
}
