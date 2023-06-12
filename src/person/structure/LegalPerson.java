package person.structure;

public class LegalPerson implements Person {
    String companyName;

    public LegalPerson(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getName() {
        return companyName;
    }

    @Override
    public void printInformation() {
        System.out.println("Company name: " + companyName);
        // TODO implement further information
    }
}
