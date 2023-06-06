package authentification.behaviour;

import authentification.structure.*;

public class AuthenticationService {

    private Subject subject;
    //private Credential credential;
    public void authenticateSubject(CredentialType credentialType) {
        Credential credential;
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
        credential.authenticate();
    }

}
