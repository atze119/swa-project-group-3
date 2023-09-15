package resource.structure;

public class ChildSeat extends ResourceAdder {
    public ChildSeat(Resource resource) {
        super(resource);
    }

    @Override
    public String getEnglishResource() {
        return super.getEnglishResource() + ", child seat";
    }

    @Override
    public String getGermanResource() {
        return super.getGermanResource() + ", Kindersitz";
    }

    @Override
    public int getCosts() {
        return super.getCosts() + 10;
    }
}
