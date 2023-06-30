package content.structure;

public abstract class Content {
    public String name;
    public int month;
    public int year;

    public Content(String name, int month, int year) {
        this.name = name;
        this.month = month;
        this.year = year;
    }

    public Content(String name) {
        this.name = name;
    }

    public abstract void addContent(Content content);

    public abstract int getSum();

    public abstract String printStructure(String prefix);

}

