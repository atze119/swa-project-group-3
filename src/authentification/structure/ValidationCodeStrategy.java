package authentification.structure;

public class ValidationCodeStrategy implements Credential {
    @Override
    public void authenticate() {
        int validation = (int) (Math.random()*(20000-10000+1)+10000);
        System.out.println("Creating Validation-Code");
        System.out.println("Done!");
        System.out.println("This is your Validation-Code: !" + validation + "$");
    }
}
