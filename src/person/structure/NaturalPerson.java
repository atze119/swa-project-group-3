package person.structure;

public class NaturalPerson implements Person {
    private String firstName, lastName;
    private boolean age, licenseAge;

    public NaturalPerson(String firstName, String lastName, boolean age, boolean licenseAge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.licenseAge = licenseAge;
    }

    @Override
    public void printInformation() {
        System.out.println("Firstname: " + firstName);
        System.out.println("Lastname: " + lastName);
        System.out.println("Old enough: " + age);
        System.out.println("Driver's license long enough: " + licenseAge);
    }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }
}
