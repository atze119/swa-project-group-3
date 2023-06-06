package authentification.structure;

public class EyeScanStrategy implements Credential {
    @Override
    public void authenticate() {
        System.out.println("You have chosen the Eyescan-Strategy");
    }
}
