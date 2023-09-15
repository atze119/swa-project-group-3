package authentication.structure;

import java.util.Scanner;

public class EyeScanStrategy implements Credential {
    @Override
    public void authenticate(Scanner sc) {
        System.out.println("You have chosen the Eyescan-Strategy");
        System.out.println("Scanning Eye");
        System.out.println("Done!\n");
    }
}
