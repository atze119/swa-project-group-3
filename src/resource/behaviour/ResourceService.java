package resource.behaviour;

import resource.structure.*;

import java.util.Scanner;

public class ResourceService { // Car == the main Resource

    // TODO maybe add something more, so you can call the booked resources for example in main class
    private Resource resource;

    public Resource getSelectedResource() { // return resource for JUnit test (null testing)
        Scanner sc = new Scanner(System.in);
        boolean userInput = false;
        while (!userInput) {
            System.out.println("If you want to book something extra to your car input 'true' or 'false' to the following questions: ");
            System.out.println("Do you want to book a child seat to your car?");
            boolean childSeat = sc.nextBoolean();

            System.out.println("Do you want do book a Top-Box to your car?");
            boolean topBox = sc.nextBoolean();

            if (childSeat && topBox) {
                resource = new ChildSeat(new RoofBox(new Car())); // car == the main resource constructor call:
            } else if (childSeat) {                    // specification -> generalization
                resource = new ChildSeat(new Car());
            } else if (topBox) {
                resource = new RoofBox(new Car());
            } else {
                resource = new Car();
            }
            System.out.println("For the booking you have selected: " + resource.getResource() + ".");
            System.out.println("The price of your selected resources is: " + resource.getCosts());
            System.out.println();
            System.out.println("If everything is right input 'true' if not input 'false' to start the selection again:");
            userInput = sc.nextBoolean();
        }
        return resource;
    }


}
