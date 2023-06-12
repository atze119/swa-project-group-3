package authentification.behaviour;

import authentification.structure.*;
import person.structure.NaturalPerson;
import person.structure.Person;
import java.util.Scanner;


public class AuthenticationService {

    public Credential authenticateSubject(Person subject) {
        Credential credential = null;
        if (subject instanceof NaturalPerson) {
            System.out.println("Choose between 'USERNAMEPASSWORDSTRATEGY', 'FINGERPRINTSTRATEGY', 'EYESCANSTRATEGY'");
            Scanner sc = new Scanner(System.in); // TODO maybe switch from enum with USERNAME... to numbers and display a list
            CredentialType credentialType = CredentialType.valueOf(sc.next());
            switch (credentialType) {
                case USERNAMEPASSWORDSTRATEGY:
                    credential = new UserNamePasswordStrategy();
                    break;
                case FINGERPRINTSTRATEGY:
                    credential = new FingerPrintStrategy();
                    break;
                case EYESCANSTRATEGY:
                    credential = new EyeScanStrategy();
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + credentialType);
            }
        } else {
            // TODO how is a LegalPerson going to authenticate itself?
        }
        credential.authenticate();
        return credential;
    }

}
