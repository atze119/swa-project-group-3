package person.behaviour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.structure.LegalPerson;
import person.structure.NaturalPerson;
import person.structure.Person;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class PersonServiceTest {
    private Person person;
    private static InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        person = null;
        System.setIn(sysInBackup);
    }

    @Test
    void testCreateNaturalPerson() {
        String userInput = "N Max Mustermann Y Y Y";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        person = PersonService.createPerson(new Scanner(System.in));
        Assertions.assertTrue(person instanceof NaturalPerson);
    }
    @Test
    void testCreateLegalPerson() {
        String userInput = "L Leuphana Y";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        person = PersonService.createPerson(new Scanner(System.in));
        Assertions.assertTrue(person instanceof LegalPerson);
    }

    @Test
    void testCreateTooYoungPerson() {
        String userInput = "N Max Mustermann N";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        person = PersonService.createPerson(new Scanner(System.in));
        Assertions.assertNull(person);
    }

    @Test
    void testCreatePersonWithoutLicense() {
        String userInput = "N Max Mustermann Y N";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        person = PersonService.createPerson(new Scanner(System.in));
        Assertions.assertNull(person);
    }
}