package content.behaviour;

import booking.structure.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.structure.Account;
import payment.structure.Payment;
import statistics.structure.Visitor;

class ContentServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addContent() {

        Booking bookingDummy = new Booking() { //TODO warum getBookingId nicht implementiert?
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
            //TODO visitor pattern changes in line 56-59
            @Override
            public void accept(Visitor visitor) {

            }

            @Override
            protected void currencyAmountFromSenderToReceiver(Account senderAccount, Account receiverAccount, Booking booking) {

            }
        };

        ContentService contentService = new ContentService();
        contentService.addContent(bookingDummy, paymentDummy);
    }
}