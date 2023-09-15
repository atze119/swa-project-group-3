package resource.structure;

public class Car implements Resource {

    @Override
    public String getEnglishResource() {
        return "car";
    }

    @Override
    public String getGermanResource() {
        return "Auto";
    }

    @Override
    public int getCosts() {
        return 200;
    }
}
