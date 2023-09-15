package resource.structure;

public class RoofBox extends ResourceAdder {

    public RoofBox(Resource resource) {
        super(resource);
    }

    @Override
    public String getEnglishResource() {
        return super.getEnglishResource() + ", roof box";
    }

    public String getGermanResource() {
        return super.getGermanResource() + ", Dachgepäckträger";
    }

    @Override
    public int getCosts() {
        return super.getCosts() + 20;
    }
}
