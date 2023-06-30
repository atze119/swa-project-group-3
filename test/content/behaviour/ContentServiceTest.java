package content.behaviour;

import booking.structure.Booking;
import content.structure.Content;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.structure.Account;
import payment.structure.Payment;

import static org.junit.jupiter.api.Assertions.*;

class ContentServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addContent() {

        Booking bookingDummy = new Booking() {
            @Override
            public void printBooking() {
            }

            @Override
            public int getCosts() {
                return 210;
            }

            @Override
            public int getBookingMonth() {
                return 11;
            }

            @Override
            public int getBookingYear() {
                return 2023;
            }

            @Override
            public int randomBookingMonth() {
                return 0;
            }
        };

        Payment paymentDummy = new Payment() {
            @Override
            protected void currencyAmountFromSenderToReceiver(Account senderAccount, Account receiverAccount, Booking booking) {

            }
        };

        ContentService contentService = new ContentService();
        contentService.addContent(bookingDummy, paymentDummy);
    }
}