package content.behaviour;

import booking.structure.Booking;
import content.structure.*;
import payment.structure.Payment;

public class ContentService {

    //TODO  Change int month and int year to different type: e.g.: LocalDate  (change starts in booking and payment)

    private final Folder root;
    private int paymentId = 1;

    public ContentService(){
        root = new Folder("Content",7,2023);
        root.addContent(new Folder("Booking",7,2023));
        root.addContent(new Folder("Payment",7,2023));
    }

    public void addContent(Booking booking, Payment payment) {

        Folder bookingFolder = getOrCreateFolder(root, "Booking");
        Folder bookingYearFolder = getOrCreateFolder(bookingFolder, "Year " + booking.getBookingYear());
        Folder bookingMonthFolder = getOrCreateFolder(bookingYearFolder, "Month " + booking.getBookingMonth());

        SimpleFile bookingFile = new SimpleFile("Booking-"+booking.getBookingId(), booking.getBookingMonth(), booking.getBookingYear(), booking.getCosts());
        bookingMonthFolder.addContent(bookingFile);

        Folder paymentFolder = getOrCreateFolder(root, "Payment");
        Folder paymentYearFolder = getOrCreateFolder(paymentFolder, "Year " + payment.getPaymentYear());
        Folder paymentMonthFolder = getOrCreateFolder(paymentYearFolder, "Month " + payment.getPaymentMonth());

        SimpleFile paymentFile = new SimpleFile("Payment-"+payment.getPaymentId(), payment.getPaymentMonth(), payment.getPaymentYear(), payment.getTransferAmount());
        paymentMonthFolder.addContent(paymentFile);
        paymentId++;

        Content content = root.getSubFolder("Summary");

        if(content instanceof SummaryFile || content == null) {
            SummaryFile summaryFile = (SummaryFile) content;
            if (summaryFile == null) {
                summaryFile = new SummaryFile("Summary");
                root.addContent(summaryFile);
            }
            summaryFile.addAmount(booking.getCosts(), payment.getTransferAmount());
            summaryFile.addBooking(booking);
            summaryFile.addPayment(payment);
        }
    }

    private Folder getOrCreateFolder(Folder parentFolder, String name){
        Folder folder = (Folder) parentFolder.getSubFolder(name);
        if (folder == null) {
            folder = new Folder(name);
            parentFolder.addContent(folder);
        }
        return folder;
    }

    public void printStructure() {
        System.out.println(root.printStructure(""));
    }
}
