package payment.behaviour;

import booking.structure.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.structure.Payment;
import person.structure.Person;

class PaymentServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void runPaymentTestMultipleTimes() {
        int numberOfIterations = 5;

        for (int i = 0; i < numberOfIterations; i++) {
            payAmount();
        }
    }


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
            Person persondummy = new Person() {
                @Override
                public String getName() {
                    return "Max Mustermann";
                }

                @Override
                public void printInformation() {

                }
            };
            PaymentService paymentService = new PaymentService();
            Payment payment = paymentService.payAmount(bookingdummy, persondummy);
            Assertions.assertNotNull(payment);
    }

}