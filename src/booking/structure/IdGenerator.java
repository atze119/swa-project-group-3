package booking.structure;

public class IdGenerator {
    private static int nextId = 1;

    public static int getNextId() {
        return nextId++;
    }
}
