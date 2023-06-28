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
        while (!correctData) { // as long as reset == false it will
            boolean correctInput = false;
            while (!correctInput) {
                System.out.println("""
                Please choose between the following two types:
                Legal Person [L] | Natural Person [N]:
                """);
                String userInput = sc.next();
                if (!userInput.equals("N") && !userInput.equals("L")) {
                    System.out.println("Please input a valid character!");
                } else {
                    personType = userInput.equals("N") ? PersonType.NATURAL_PERSON : PersonType.LEGAL_PERSON;
                    correctInput = true;
                }
            }
            PersonFactory personFactory = new PersonFactory();
            person = personFactory.create(personType);
            if (person != null) {
                correctInput = false;
                while (!correctInput) {
                    System.out.println();
                    System.out.println("Printing Information!");
                    person.printInformation();
                    System.out.println("Is your Data correct? Yes [Y] | No [N]");
                    System.out.println();
                    String validData = sc.next();
                    if (!validData.equals("Y") && !validData.equals("N")) {
                        System.out.println("Please input a valid character!");
                    } else if (validData.equals("Y")) {
                        correctData = true;
                        correctInput = true;
                    }
                }
            } else {
                break;
            }
        }
        return person;
    }


}
