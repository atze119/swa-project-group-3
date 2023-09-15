package authentication.behaviour;

import authentication.structure.Credential;
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

public class AuthenticationServiceTest {
    private AuthenticationService authenticationService;
    private InputStream sysInBackup;
    private Person legalPerson;
    private Person naturalPerson;


    @BeforeEach
    void setUp() {
        authenticationService = new AuthenticationService();
        sysInBackup = System.in;
        legalPerson = new LegalPerson("Leuphana");
        naturalPerson = new NaturalPerson("Max", "Mustermann", true, true);
    }

    @AfterEach
    void tearDown() {
        legalPerson = null;
        naturalPerson = null;
        authenticationService = null;
        System.setIn(sysInBackup);

    }

    @Test
    public void testAuthenticateLegalSubject() {
        Credential credential = authenticationService.authenticateSubject(legalPerson, new Scanner(System.in));
        Assertions.assertNotNull(credential);
    }

    @Test
    public void testAuthenticateNaturalSubject() {
        String userInput = "2"; // authenticate-strategy
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Credential credential = authenticationService.authenticateSubject(naturalPerson, new Scanner(System.in));
        Assertions.assertNotNull(credential);
    }

}