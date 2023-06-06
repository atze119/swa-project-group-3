package authentification.structure;

public class UserNamePasswordStrategy implements Credential {
    @Override
    public void authenticate() {
        System.out.println("You have chosen the Username-Password-Strategy");
    }
}
