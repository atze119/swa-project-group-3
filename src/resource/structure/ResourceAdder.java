package resource.structure;

public abstract class ResourceAdder implements Resource {
    private Resource resource;

    public ResourceAdder(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String addResource() {
        return resource.addResource();
    }
}
