import java.util.Scanner;

class Order {
    char weight; 
    int distance; 
    double price; 

    double fees; 

}

class Calc {
    public static void main(String[] args) {

        System.out
                .println("Welcome to the Delivery Fees Calculator. You will now be inputting details for a new order.");
        Scanner s = new Scanner(System.in);

        Order current = new Order();
        System.out.println("Your options are l for light, m for medium and h for heavy.");
        System.out.println("Please enter the weight classification: ");

        current.weight = s.next().charAt(0);
        String CurWeight = "";
        if (current.weight == 'm' || current.weight == 'M') {
            CurWeight = "Medium";
        } else if (current.weight == 'l' || current.weight == 'L') {
            CurWeight = "Light";
        } else if (current.weight == 'h' || current.weight == 'H') {
            CurWeight = "Heavy";
        } else {
            System.out.println("Weight classification invalid. Please choose one of the available options.");
        }

        System.out.println(
                "After checking google maps for the location, please summarize the number of minutes to delivery");
        System.out.println("Please enter this number of minutes: ");
        current.distance = s.nextInt();
        int CurDistance = current.distance;

        System.out.println("After picking up the order, please determine the total paid price in the format of 00.00");
        System.out.println("Please enter this total price:");
        current.price = s.nextDouble();
        double CurPrice = current.price;

        double CurFees = 00.00;

        {
            if (CurDistance < 10) {
                CurFees += 0.5;
            } else if (10 < CurDistance && CurDistance < 20) {
                CurFees += 1;
            } else if (CurDistance > 20) {
                CurFees += 2;
            }

            if (CurWeight.equals("Heavy")) {
                CurFees += 2.0;
            } else if (CurWeight.equals("Medium")) {
                CurFees += 1.5;
            } else if (CurWeight.equals("Light")) {
                CurFees += 0.5;
            }

            if (CurPrice < 10) {
                CurFees += 0.5;
            } else {
                CurFees += 1;
            }

        }

        double Total = CurFees + CurPrice;

        System.out.println("The current order's is considered " + CurWeight + ".");
        System.out.println("The current order will take " + CurDistance + " minutes to deliver.");
        System.out.println("The current order's total paid is £" + CurPrice + ", excluding delivery fees.");
        System.out.println();
        System.out.println("Based on this, the order's delivery fees are: " + CurFees);
        System.out.println("Therefore, courier should ask customer for: " + Total);

        s.close();
    }
}
