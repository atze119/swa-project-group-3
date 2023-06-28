package person.structure;

import java.util.Scanner;

public class PersonFactory {
    public Person create(PersonType personType) {
        Person person;
        Scanner sc = new Scanner(System.in);
        switch (personType) {
            case NATURAL_PERSON:
                System.out.println("What is your First- and Lastname?");
                String firstName = sc.next();
                String lastName = sc.next(); // TODO implement if else to check if input is valid
                System.out.println("Are you older than 21? (type 'true' or 'false')");
                boolean age = sc.nextBoolean();
                if (age == false) {
                    System.out.println("Sorry you are to young for our service.");
                    return null;
                }
                System.out.println("Do you have your driver's license since 3 years? (type 'true' or 'false')");
                boolean licenseAge = sc.nextBoolean();
                if (licenseAge == false) {
                    System.out.println("Sorry thats not long enough for our service.");
                    return null;
                }
                person = new NaturalPerson(firstName, lastName, age, licenseAge);
                break;
            case LEGAL_PERSON:
                System.out.println("What is the name of your company?");
                String companyName = sc.nextLine();
                person = new LegalPerson(companyName);
                break;
            default:
                throw new IllegalArgumentException("Unexpected Value: " + personType);
        }

        return person;
    }
}
