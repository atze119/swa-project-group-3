package resource.structure;

public abstract class ResourceAdder implements Resource {
    private final Resource resource;

    public ResourceAdder(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String getEnglishResource() {
        return resource.getEnglishResource();
    }

    @Override
    public String getGermanResource() {
        return resource.getGermanResource();
    }

    @Override
    public int getCosts(){return resource.getCosts();}

}
