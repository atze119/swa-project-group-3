package resource.behaviour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resource.structure.Car;
import resource.structure.ChildSeat;
import resource.structure.Resource;
import resource.structure.RoofBox;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class ResourceServiceTest {
    private static InputStream sysInBackup;
    private ResourceService resourceService;

    @BeforeEach
    void setUp() {
        resourceService = new ResourceService();
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        resourceService = null;
        System.setIn(sysInBackup);
    }

    @Test
    void testSelectingNoExtras() {
        String userInput = "N N Y";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Resource resource = resourceService.getSelectedResource();
        Assertions.assertTrue(resource instanceof Car);
    }

    @Test
    void testSelectingChildSeat() {
        String userInput = "Y N Y";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Resource resource = resourceService.getSelectedResource();
        Assertions.assertTrue(resource instanceof ChildSeat);
    }

    @Test
    void testSelectingRoofBox() {
        String userInput = "N Y Y";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Resource resource = resourceService.getSelectedResource();
        Assertions.assertTrue(resource instanceof RoofBox);
    }

    @Test
    void testSelectingEverything() {
        String userInput = "Y Y Y";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Resource resource = resourceService.getSelectedResource();
         Assertions.assertEquals(resource.getCosts(), 230); // Couldve also done this Assertions.assertTrue(resource instanceof ChildSeat);
    }


}