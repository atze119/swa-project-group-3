package resource.behaviour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resource.structure.Car;
import resource.structure.ChildSeat;
import resource.structure.Resource;
import resource.structure.RoofBox;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ResourceServiceTest {
    //TODO change console inputs to constant values
    boolean bookExtra;
    @BeforeEach
    void setUp() {
        bookExtra = true;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSelectedResource() {
        Scanner sc = new Scanner(System.in);
        boolean userInput = false;
        while (!userInput) {
            System.out.println("If you want to book something extra to your car input [Y] for Yes or [N] for No to the following questions: ");
            System.out.println("Do you want to book a child seat to your car?");
            boolean childSeat = bookExtra;

            System.out.println("Do you want do book a Roof-Box to your car?");
            boolean roofBox = bookExtra;
//            if (childSeat && roofBox) {
//                resource = new ChildSeat(new RoofBox(new Car())); // car == the main resource constructor call:
//            } else if (childSeat) {                    // specification -> generalization
//                resource = new ChildSeat(new Car());
//            } else if (roofBox) {
//                resource = new RoofBox(new Car());
//            } else {
//                resource = new Car();
//            }
//            System.out.println("For the booking you have selected: " + resource.getResource() + ".");
//            System.out.println("The price of your selected resources is: " + resource.getCosts());
            System.out.println();

            System.out.println("If everything is right input [Y] for Yes if not input [N] for No to start the selection again:");
            boolean validInput = false;
            while (!validInput) {
                String validData = sc.next();
                if (!validData.matches("Y|y|N|n")) {
                    System.out.println("Please input a valid character! [Y] | [N]");
                } else if (validData.matches("Y|y")){
                    userInput = true;
                    validInput = true;
                } else {
                    validInput = true;
                }
            }
        }
//        return resource;
    }
}