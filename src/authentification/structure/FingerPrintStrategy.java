package authentification.structure;

public class FingerPrintStrategy implements Credential {
    @Override
    public void authenticate() {
        System.out.println("You have chosen the Fingerprint-Strategy");
    }
}
