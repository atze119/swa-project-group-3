package resource.structure;

public class Car implements Resource {

    @Override
    public String getResource() {
        return "car";
    }

    @Override
    public int getCosts() {
        return 200;
    }
}
