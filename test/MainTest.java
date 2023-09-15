import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.structure.NaturalPerson;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MainTest {
    private InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(sysInBackup);
    }

    @Test
    void main() {
        String[] args = null;
        String userInput = "N Max Mustermann Y Y Y 2 Y Y Y G 1 N";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Main.main(args);
        //Assertions.assertEquals(NaturalPerson.);
    }
}