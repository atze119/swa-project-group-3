package authentication.structure;

import java.util.Scanner;

public class ValidationCodeStrategy implements Credential {
    @Override
    public void authenticate(Scanner sc) {
        int validation = (int) (Math.random()*(20000-10000+1)+10000);
        System.out.println("Creating Validation-Code");
        System.out.println("Done!");
        System.out.println("This is your Validation-Code: !" + validation + "$\n");
    }
}
