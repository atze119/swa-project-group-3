import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import person.behaviour.PersonService;
import person.structure.Person;
import person.structure.PersonType;

import java.util.Scanner;

class PersonServiceTest {

    private static PersonType personType;
    private static Person person; // to be able to access person in other methods

    @BeforeAll
    static void beforeAll() {
    }

    @AfterAll
    static void shutDown() {

    }
        // TODO change VM https://stackoverflow.com/questions/38482844/reading-system-in-from-the-console-using-intellij-and-junit
    @Test
    void createPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose between the following two types: 'LEGAL_PERSON', 'NATURAL_PERSON'");
        //PersonService personService = new PersonService(); when static stays
        personType = PersonType.valueOf(sc.next());
        person = PersonService.createPerson(personType);
        Assertions.assertNotNull(person);
    }
}