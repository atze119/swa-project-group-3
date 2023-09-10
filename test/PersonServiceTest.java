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
        //TODO  write test; change VM https://stackoverflow.com/questions/38482844/reading-system-in-from-the-console-using-intellij-and-junit
    @Test
    void createPerson() {
        person = PersonService.createPerson();
        Assertions.assertNotNull(person);
    }
}