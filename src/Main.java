import authentification.behaviour.AuthenticationService;
import authentification.structure.CredentialType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose between 'USERNAMEPASSWORDSTRATEGY', 'FINGERPRINTSTRATEGY', 'EYESCANSTRATEGY'");
        Scanner sc = new Scanner(System.in);
        CredentialType credentialType = CredentialType.valueOf(sc.next());
        AuthenticationService service = new AuthenticationService();
        service.authenticateSubject(credentialType);
    }
}