package content.structure;

public class SimpleContent extends Content{

    private int amount;

    public SimpleContent(String name, int month, int year, int amount) {
        super(name, month, year);
        this.amount = amount;
    }

    @Override
    public void addContent(Content content) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSum() {
        return amount;
    }

    @Override
    public String printStructure(String prefix) {
        return prefix + "- File: " + name + "\n";
    }
}
