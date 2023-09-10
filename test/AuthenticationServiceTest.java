import authentification.behaviour.AuthenticationService;
import authentification.structure.Credential;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import person.structure.LegalPerson;
import person.structure.NaturalPerson;
import person.structure.Person;
import person.structure.PersonType;

import java.util.Scanner;

class AuthenticationServiceTest {

    @BeforeAll
    static void beforeAll() {
    }

    @AfterAll
    static void shutDown() {

    }
        //TODO change VM https://stackoverflow.com/questions/38482844/reading-system-in-from-the-console-using-intellij-and-junit
        //TODO implement working Test
    @Test
    void authenticateSubject() {
        Person person = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose between the following two types: 'LEGAL_PERSON', 'NATURAL_PERSON'");
        PersonType personType = PersonType.valueOf(sc.next());
        switch (personType) {
            case LEGAL_PERSON -> person = new LegalPerson("test");
            case NATURAL_PERSON -> person = new NaturalPerson("test", "test", true, true);
        }
        AuthenticationService authenticationService = new AuthenticationService();
        Credential credential = authenticationService.authenticateSubject(person);
        Assertions.assertNotNull(credential);
    }
}