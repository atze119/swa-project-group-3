package content.structure;

public class SimpleFile extends File{

    private int amount;

    public SimpleFile(String name, int month, int year, int amount) {
        super(name, month, year);
        this.amount = amount;
    }

    @Override
    public void addContent(Content content) {
        throw new UnsupportedOperationException("Cannot add content to File");
    }

    @Override
    public int getSum() {
        return amount;
    }

    @Override
    public String printStructure(String prefix) {
        return prefix + "- File: " + name + ": " + "Date: " + month + "." + year + " Amount: " + amount + "\n";
    }
}
