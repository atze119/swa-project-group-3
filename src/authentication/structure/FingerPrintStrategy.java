package authentication.structure;

import java.util.Scanner;

public class FingerPrintStrategy implements Credential {
    @Override
    public void authenticate(Scanner sc) {
        System.out.println("You have chosen the Fingerprint-Strategy");
        System.out.println("Scanning Finger");
        System.out.println("Done!\n");
    }
}
