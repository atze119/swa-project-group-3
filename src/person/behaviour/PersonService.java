package person.behaviour;

import person.structure.Person;
import person.structure.PersonFactory;
import person.structure.PersonType;

import java.util.Scanner;

public class PersonService {

    public static Person createPerson(Scanner sc) {
        Person person = null;
        PersonType personType= null;
        boolean correctData = false;
        while (!correctData) { // as long as reset == false it will
            boolean correctInput = false;
            while (!correctInput) {
                System.out.println("""
                Please choose between the following two types:
                Legal Person [L] | Natural Person [N]
                """);
                String userInput = sc.next();
                if (!userInput.matches("N|n|L|l")) {
                    System.out.println("Please input a valid character! [L] | [N]");
                } else {
                    personType = userInput.matches("N|n") ? PersonType.NATURAL_PERSON : PersonType.LEGAL_PERSON;
                    correctInput = true;
                }
            }
            PersonFactory personFactory = new PersonFactory();
            person = personFactory.create(personType, sc);
            if (person != null) {
                correctInput = false;
                System.out.println();
                System.out.println("Printing Information!");
                person.printInformation();
                System.out.println("Is your Data correct? Yes [Y] | No [N]");
                System.out.println();
                while (!correctInput) {
                    String validData = sc.next();
                    if (!validData.matches("Y|y|N|n")) {
                        System.out.println("Please input a valid character! [Y] | [N]");
                    } else if (validData.matches("Y|y")) {
                        correctData = true;
                        correctInput = true;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return person;
    }


}
