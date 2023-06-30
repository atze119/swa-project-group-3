package content.structure;

import java.util.ArrayList;
import java.util.List;

public class File extends Content{

    private int fullBookingAmount;
    private int fullPaymentAmount;
    private int sum;
    public File(String name, int month, int year) {
        super(name, month, year);
        this.fullBookingAmount = 0;
        this.fullPaymentAmount = 0;
    }

    public File(String name) {
        super(name, 0,0);
        this.fullBookingAmount = 0;
        this.fullPaymentAmount = 0;
    }

    public void addAmount(int bookingAmount, int paymentAmount){
        this.fullBookingAmount += bookingAmount;
        this.fullPaymentAmount += paymentAmount;
    }

    public void addBookingAmount(int bookingAmount){
        this.fullBookingAmount += bookingAmount;
    }

    public void addPaymentAmount(int paymentAmount){
        this.fullPaymentAmount += paymentAmount;
    }

    public int getFullBookingAmount() {
        return fullBookingAmount;
    }

    public int getFullPaymentAmount() {
        return fullPaymentAmount;
    }

    @Override
    public void addContent(Content content) {
        throw new UnsupportedOperationException("Cannot add content to File");
    }

    @Override
    public int getSum() {
        return fullBookingAmount-fullPaymentAmount;
    }


    @Override
    public String printStructure(String prefix) {
        return prefix + "- File: " + name + " (Sum: " + sum + ")\n";
    }
}
