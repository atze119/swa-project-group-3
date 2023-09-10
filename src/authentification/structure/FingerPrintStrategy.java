package authentification.structure;

public class FingerPrintStrategy implements Credential {
    @Override
    public void authenticate() {
        System.out.println("You have chosen the Fingerprint-Strategy");
        System.out.println("Scanning Finger");
        System.out.println("Done!");
    }
}
