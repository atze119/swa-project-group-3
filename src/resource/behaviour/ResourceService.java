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
            System.out.println("If you want to book something extra to your car input [Y] for Yes or [N] for No to the following questions: ");
            System.out.println("Do you want to book a child seat to your car?");
            boolean childSeat = bookExtra();

            System.out.println("Do you want do book a Roof-Box to your car?");
            boolean roofBox = bookExtra();

            if (childSeat && roofBox) {
                resource = new ChildSeat(new RoofBox(new Car())); // car == the main resource constructor call:
            } else if (childSeat) {                    // specification -> generalization
                resource = new ChildSeat(new Car());
            } else if (roofBox) {
                resource = new RoofBox(new Car());
            } else {
                resource = new Car();
            }
            System.out.println("For the booking you have selected: " + resource.getResource() + ".");
            System.out.println("The price of your selected resources is: " + resource.getCosts());
            System.out.println();

            System.out.println("If everything is right input [Y] for Yes if not input [N] for No to start the selection again:");
            boolean validInput = false;
            while (!validInput) {
                String checkUserInput = sc.next();
                if (!checkUserInput.equals("Y") && !checkUserInput.equals("N")) {
                    System.out.println("Please input a valid character! [Y] | [N]");
                } else if (checkUserInput.equals("Y")){
                    userInput = true;
                    validInput = true;
                } else {
                    validInput = true;
                }
            }
        }
        return resource;
    }

    private boolean bookExtra() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.next();
            if (!userInput.equals("Y") && !userInput.equals("N")) {
                System.out.println("Please input a valid character! [Y] | [N]");
            } else if (userInput.equals("Y")){
                return true;
            } else {
                return false;
            }
        }
    }


}
