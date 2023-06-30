package content.behaviour;

import booking.structure.Booking;
import content.structure.*;
import payment.structure.Payment;

public class ContentService {

    private Folder root;

    public ContentService(){
        root = new Folder("content",6,2023);
        root.addContent(new Folder("Booking",6,2023));
        root.addContent(new Folder("Payment",6,2023));
    }

    public void addContent(Booking booking, Payment payment) {
        Folder bookingFolder = getOrCreateFolder(root, "Booking");
        Folder bookingYearFolder = getOrCreateFolder(bookingFolder, "Year " + booking.getBookingYear());
        Folder bookingMonthFolder = getOrCreateFolder(bookingYearFolder, "Month " + booking.getBookingMonth());

        SimpleContent bookingContent = new SimpleContent("Booking", booking.getBookingMonth(), booking.getBookingYear(), booking.getCosts());
        bookingMonthFolder.addContent(bookingContent);

        Folder paymentFolder = getOrCreateFolder(root, "Payment");
        Folder paymentYearFolder = getOrCreateFolder(paymentFolder, "Year " + payment.getPaymentYear());
        Folder paymentMonthFolder = getOrCreateFolder(paymentYearFolder, "Month " + payment.getPaymentMonth());

        SimpleContent paymentContent = new SimpleContent("Payment", payment.getPaymentMonth(), payment.getPaymentYear(), payment.getTransferAmount());
        paymentMonthFolder.addContent(paymentContent);

        File summaryFile = (File) root.getSubFolder("Summary");

        if (summaryFile == null) {
            summaryFile = new File("Summary");
            root.addContent(summaryFile);
        }

        summaryFile.addAmount(booking.getCosts(), payment.getTransferAmount());
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
