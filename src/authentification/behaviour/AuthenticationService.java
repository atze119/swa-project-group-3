package authentification.behaviour;

import authentification.structure.*;
import person.structure.NaturalPerson;
import person.structure.Person;
import java.util.Scanner;


public class AuthenticationService {

    public Credential authenticateSubject(Person subject) {    //Subject als Fachtyp eigene Klasse?
        Credential credential;
        if (subject instanceof NaturalPerson) {
            System.out.println("""
                    Choose between Username-Password-Strategy: 1
                    Fingerprint-Scan-Strategy: 2
                    Eye-Scan-Strategy: 3
                    """);
            Scanner sc = new Scanner(System.in);
            int credentialType = sc.nextInt();

            credential = switch (credentialType) {
                case 1 -> new UserNamePasswordStrategy();
                case 2 -> new FingerPrintStrategy();
                case 3 -> new EyeScanStrategy();
                default -> throw new IllegalArgumentException("Unexpected value: " + credentialType);
            };

        } else {
            credential = new ValidationCodeStrategy();
            // At this point Legal person has only one strategy
        }
        credential.authenticate();
        return credential;
    }

}
