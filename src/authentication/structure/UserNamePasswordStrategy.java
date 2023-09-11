package authentication.structure;

import java.util.Scanner;

public class UserNamePasswordStrategy implements Credential {
    @Override
    public void authenticate(Scanner sc) {
        System.out.println("You have chosen the Username-Password-Strategy");
        System.out.println("Input your Username");
        sc.next();
        System.out.println("Input your Password");
        sc.next();
        System.out.println("Registered!");
    }
}
