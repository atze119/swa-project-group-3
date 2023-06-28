package person.behaviour;

import person.structure.Person;
import person.structure.PersonFactory;
import person.structure.PersonType;

import java.util.Scanner;

public class PersonService {

    public static Person createPerson() { // TODO is static wrong?
        Person person = null;
        PersonType personType= null;
        boolean correctData = false;
        Scanner sc = new Scanner(System.in);
        boolean correctInput = false;
        while (!correctInput) {
            System.out.println("""
            Please choose between the following two types:
            Legal Person [L] | Natural Person [N]:
            """);
            String userInput = sc.next();
            if (!userInput.equals("N") && !userInput.equals("L")) {
                System.out.println("Please type a valid character!");
            } else {
                personType = userInput.equals("n") ? PersonType.NATURAL_PERSON : PersonType.LEGAL_PERSON;
                correctInput = true;
            }
        }
        while (!correctData) { // as long as reset == false it will
            PersonFactory personFactory = new PersonFactory();
            person = personFactory.create(personType);
            if (person != null) {
                System.out.println();
                System.out.println("Check if your data is correct");
                person.printInformation();
                System.out.println();
                System.out.println("If anything is wrong type 'false' to reset your Data. If not type 'true' to go on.");
                correctData = sc.nextBoolean(); // check to exit the loop
            } else {
                break;
            }
        }
        return person;
    }


}
