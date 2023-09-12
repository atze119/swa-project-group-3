package authentication.behaviour;

import authentication.behaviour.AuthenticationService;
import authentication.structure.Credential;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import person.structure.LegalPerson;
import person.structure.NaturalPerson;
import person.structure.Person;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class AuthenticationServiceTest {
    private static AuthenticationService authenticationService;
    private static InputStream sysInBackup;
    private static Person legalPerson;
    private static Person naturalPerson;


    @BeforeAll
    static void beforeAll() {
        authenticationService = new AuthenticationService();
        sysInBackup = System.in;
        legalPerson = new LegalPerson("Leuphana");
        naturalPerson = new NaturalPerson("Max", "Mustermann", true, true);
    }

    @AfterAll
    static void shutDown() {
        authenticationService = null;
        System.setIn(sysInBackup);

    }
        //TODO implement working Test
    @Test
    void authenticateLegalSubject() {
        Credential credential = authenticationService.authenticateSubject(legalPerson);
        Assertions.assertNotNull(credential);
    }

    @Test
    void authenticateNaturalSubject() {
        String userInput = "2"; // authenticate-strategy
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Credential credential = authenticationService.authenticateSubject(naturalPerson);
        Assertions.assertNotNull(credential);
    }

}