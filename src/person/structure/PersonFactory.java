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
                boolean correctInput = false;
                boolean age = false;
                while (!correctInput) {
                    System.out.println("Are you older than 21? Yes [Y] | No [N]");
                    String validAge = sc.next();
                    if (!validAge.equals("Y") && !validAge.equals("N")) {
                        System.out.println("Please input a valid character! [Y] | [N]");
                    } else if (validAge.equals("Y")) {
                        age = true;
                        correctInput = true;
                    } else {
                        System.out.println("Sorry you are to young for our service.");
                        return null;  // return null because we test if the return value (person) == null
                    }
                }
                correctInput = false;
                boolean licenseAge = false;
                while(!correctInput) {
                    System.out.println("Do you have your driver's license since 3 years? Yes [Y] | No [N]");
                    String validLicenseAge = sc.next();
                    if (!validLicenseAge.equals("Y") && !validLicenseAge.equals("N")) {
                        System.out.println("Please input a valid character! [Y] | [N]");
                    } else if (validLicenseAge.equals("Y")) {
                        licenseAge = true;
                        correctInput = true;
                    } else {
                        System.out.println("Sorry thats not long enough for our service.");
                        return null;
                    }
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
