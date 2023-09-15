package authentication.behaviour;

import authentication.structure.*;
import person.structure.NaturalPerson;
import person.structure.Person;
import java.util.Scanner;


public class AuthenticationService {

    public Credential authenticateSubject(Person subject, Scanner sc) {    //Subject als Fachtyp eigene Klasse?
        Credential credential = null;
        if (subject instanceof NaturalPerson) {
            System.out.println("""
                    Choose between Username-Password-Strategy: 1
                    Fingerprint-Scan-Strategy: 2
                    Eye-Scan-Strategy: 3
                    """);
            boolean validInput = false;
            while (!validInput) {
                String userInput = sc.next();
                if (!userInput.matches("1|2|3")) {
                    System.out.println("Please input a valid number between 1 and 3! ");
                } else {
                    int inputParse = Integer.parseInt(userInput);
                    credential = switch (inputParse) {
                        case 1 -> new UserNamePasswordStrategy();
                        case 2 -> new FingerPrintStrategy();
                        case 3 -> new EyeScanStrategy();
                        default -> throw new IllegalArgumentException("Unexpected value: " + userInput);
                    };
                    validInput = true;
                }
            }
        } else {
            credential = new ValidationCodeStrategy();
            // At this point Legal person has only one strategy
        }
        credential.authenticate(sc);
        return credential;
    }

}
