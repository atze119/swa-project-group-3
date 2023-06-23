package resource.behaviour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resource.structure.Resource;

import static org.junit.jupiter.api.Assertions.*;

class ResourceServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSelectedResource() {
        ResourceService resourceService = new ResourceService();
        Resource resource = resourceService.getSelectedResource();
        assertNotNull(resource);
    }
}