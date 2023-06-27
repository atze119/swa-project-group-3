package payment.behaviour;

import booking.structure.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.structure.Payment;

class PaymentServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void payAmount() {
        // TODO implement Test
        Booking bookingdummy = new Booking() {
            @Override
            public void printBooking() {

            }

            @Override
            public int getCosts() {
                return 200;
            }
        };
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.payAmount(bookingdummy);
        Assertions.assertNotNull(payment);
    }
}