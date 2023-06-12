import authentification.behaviour.AuthenticationService;
import person.behaviour.PersonService;
import person.structure.Person;
import person.structure.PersonType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose between the following two types: 'LEGAL_PERSON', 'NATURAL_PERSON'");
        //PersonService personService = new PersonService(); when static stays
        Person person = PersonService.createPerson(PersonType.valueOf(sc.next()));
        AuthenticationService authenticationService = new AuthenticationService();
        authenticationService.authenticateSubject(person);
    }
}