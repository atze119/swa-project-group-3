package resource.structure;

public class RoofBox extends ResourceAdder { // TODO in exam the name should be "SetTopBox" i think that makes no sense
    public RoofBox(Resource resource) {
        super(resource);
    }

    @Override
    public String addResource() {
        return super.addResource() + ", roof box";
    }
}
