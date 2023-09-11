package person.behaviour;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import person.behaviour.PersonService;
import person.structure.Person;
import person.structure.PersonType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class PersonServiceTest {
    private Person person; // to be able to access person in other methods
    private static InputStream sysInBackup;

    @BeforeAll
    static void beforeAll() {
        sysInBackup = System.in;
    }

    @AfterAll
    static void shutDown() {
        System.setIn(sysInBackup);
    }
    @Test
    void createPerson() { // TODO different methods to mock userInput
        // String userInput = "N" + System.lineSeparator() + "Fynn" + System.lineSeparator() + "Juranek";
        String userInput = "N Max Mustermann Y Y Y";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        person = PersonService.createPerson();
        Assertions.assertNotNull(person);
    }
}