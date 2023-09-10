package resource.structure;

public class RoofBox extends ResourceAdder {

    public RoofBox(Resource resource) {
        super(resource);
    }

    @Override
    public String getResource() {
        return super.getResource() + ", roof box";
    }

    @Override
    public int getCosts() {
        return super.getCosts() + 20;
    }
}
