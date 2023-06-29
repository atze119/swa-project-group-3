package authentification.behaviour;

import authentification.structure.*;
import person.structure.NaturalPerson;
import person.structure.Person;
import java.util.Scanner;


public class AuthenticationService {

    public Credential authenticateSubject(Person subject) {    //Subject als Fachtyp eigene Klasse?
        Credential credential = null;
        if (subject instanceof NaturalPerson) {
            System.out.println("""
                    Choose between Username-Password-Strategy: 1
                    Fingerprint-Scan-Strategy: 2
                    Eye-Scan-Strategy: 3
                    """);
            Scanner sc = new Scanner(System.in);
            boolean validInput = false;
            while (!validInput) {
                int credentialType = sc.nextInt();
                if (credentialType < 1 || credentialType > 3) {
                    System.out.println("Please input a valid number between 1 and 3! ");
                } else {
                    credential = switch (credentialType) {
                        case 1 -> new UserNamePasswordStrategy();
                        case 2 -> new FingerPrintStrategy();
                        case 3 -> new EyeScanStrategy();
                        default -> throw new IllegalArgumentException("Unexpected value: " + credentialType);
                    };
                    validInput = true;
                }
            }
        } else {
            credential = new ValidationCodeStrategy();
            // At this point Legal person has only one strategy
        }
        credential.authenticate();
        return credential;
    }

}
