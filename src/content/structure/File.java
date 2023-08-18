package content.structure;

import booking.structure.Booking;

import java.util.ArrayList;
import java.util.List;

public abstract class File extends Content{


    public File(String name, int month, int year) {
        super(name, month, year);
    }

    @Override
    public void addContent(Content content) {
        throw new UnsupportedOperationException("Cannot add content to File");
    }

    @Override
    public int getSum() {
        return 0;
    }


    @Override
    public String printStructure(String prefix) {
        return "";
    }

    public void addAmount(int costs, int transferAmount) {
    }

}
