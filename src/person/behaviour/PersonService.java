package person.behaviour;

import person.structure.Person;
import person.structure.PersonFactory;
import person.structure.PersonType;

import java.util.Scanner;

public class PersonService {

    public static Person createPerson(PersonType personType) { // TODO is static wrong?
        Person person = null;
        boolean correctData = false;
        while (!correctData) { // as long as reset == false it will
            PersonFactory personFactory = new PersonFactory();
            person = personFactory.create(personType);
            if (person != null) {
                System.out.println();
                System.out.println("Check if your data is correct");
                person.printInformation();
                System.out.println();
                System.out.println("If anything is wrong type 'false' to reset your Data. If not type 'true' to go on.");
                Scanner sc = new Scanner(System.in);
                correctData = sc.nextBoolean(); // check to exit the loop
            } else {
                break;
            }
        }
        return person;
    }


}
