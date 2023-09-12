package person.structure;

import java.util.Scanner;

public class PersonFactory {
    public Person create(PersonType personType, Scanner sc) {
        Person person;
        switch (personType) {
            case NATURAL_PERSON -> {
                System.out.println("What is your firstname?");
                String firstName = sc.next();
                System.out.println("What is your lastname?");
                String lastName = sc.next();
                boolean correctInput = false;
                boolean age = false;
                while (!correctInput) {
                    System.out.println("Are you older than 21? Yes [Y] | No [N]");
                    String validAge = sc.next();
                    if (!validAge.matches("Y|y|N|n")) {
                        System.out.println("Please input a valid character! [Y] | [N]");
                    } else if (validAge.matches("Y|y")) {
                        age = true;
                        correctInput = true;
                    } else {
                        System.out.println("Sorry you are to young for our service.");
                        return null;  // return null because we test if the return value (person) == null
                    }
                }
                correctInput = false;
                boolean licenseAge = false;
                while (!correctInput) {
                    System.out.println("Do you have your driver's license since 3 years? Yes [Y] | No [N]");
                    String validLicenseAge = sc.next();
                    if (!validLicenseAge.matches("Y|y|N|n")) {
                        System.out.println("Please input a valid character! [Y] | [N]");
                    } else if (validLicenseAge.matches("Y|y")) {
                        licenseAge = true;
                        correctInput = true;
                    } else {
                        System.out.println("Sorry thats not long enough for our service.");
                        return null;
                    }
                }
                person = new NaturalPerson(firstName, lastName, age, licenseAge);
            }
            case LEGAL_PERSON -> {
                System.out.println("What is the name of your company?");
                String companyName = sc.next();
                person = new LegalPerson(companyName);
            }
            default -> throw new IllegalArgumentException("Unexpected Value: " + personType);
        }
        return person;
    }
}
