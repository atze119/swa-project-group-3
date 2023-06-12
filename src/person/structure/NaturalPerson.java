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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getAge() {
        return age;
    }

    public void setAge(boolean age) {
        this.age = age;
    }

    public boolean getLicenseAge() {
        return licenseAge;
    }

    @Override
    public void printInformation() {
        System.out.println("Firstname: " + firstName);
        System.out.println("Lastname: " + lastName);
        System.out.println("Old enough: " + age);
        System.out.println("Driver's license long enough: " + licenseAge);
    }

    public void setLicenseAge(boolean licenseAge) {
        this.licenseAge = licenseAge;
    }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }
}
