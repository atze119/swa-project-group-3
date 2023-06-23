package resource.structure;

public class ChildSeat extends ResourceAdder {
    public ChildSeat(Resource resource) {
        super(resource);
    }

    @Override
    public String addResource() {
        return super.addResource() + ", child seat";
    }
}
