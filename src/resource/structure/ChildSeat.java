package resource.structure;

public class ChildSeat extends ResourceAdder {
    public ChildSeat(Resource resource) {
        super(resource);
    }

    @Override
    public String getResource() {
        return super.getResource() + ", child seat";
    }
}
