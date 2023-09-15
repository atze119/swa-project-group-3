package resource.behaviour;

import resource.structure.*;

import java.util.Scanner;

public class ResourceService { // Car == the main Resource

    private Resource resource;

    public Resource getSelectedResource(Scanner sc) { // return resource for JUnit test (null testing)
        boolean userInput = false;
        while (!userInput) {
            System.out.println("If you want to book something extra to your car input [Y] for Yes or [N] for No to the following questions: ");
            System.out.println("Do you want to book a child seat to your car?");
            boolean childSeat = bookExtra(sc);

            System.out.println("Do you want do book a Roof-Box to your car?");
            boolean roofBox = bookExtra(sc);

            if (childSeat && roofBox) {
                resource = new ChildSeat(new RoofBox(new Car())); // car == the main resource constructor call:
            } else if (childSeat) {                    // specification -> generalization
                resource = new ChildSeat(new Car());
            } else if (roofBox) {
                resource = new RoofBox(new Car());
            } else {
                resource = new Car();
            }
            System.out.println("For the booking you have selected: " + resource.getEnglishResource());
            System.out.println("The price of your selected resources is: " + resource.getCosts());
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
        return resource;
    }

    private boolean bookExtra(Scanner sc) {
        while (true) {
            String userInput = sc.next();
            if (!userInput.matches("Y|y|N|n")) {
                System.out.println("Please input a valid character! [Y] | [N]");
            } else {
                return userInput.matches("Y|y"); // if input == Y return true otherwise false
            }
        }
    }


}
