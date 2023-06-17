package resource.structure;

public class RoofBox extends ResourceAdder {
    public RoofBox(Resource resource) {
        super(resource);
    }

    @Override
    public String addResource() {
        return super.addResource() + ", roof box";
    }
}
