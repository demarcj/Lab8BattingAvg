package bootcamp;

import java.util.Scanner;

/**
 * Created by DeMarcj on 2/10/2017.
 */
public class BattingAvg {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Batting Average Calculator!");
        getBat(scan);
        //Calculate the batting average and slugging percentage for one or more baseball/softball players.
        //Ask for the number of batters
        //For each at bat, ask the user for the number of bases earned by the batter.
        //Validate the input so that the user can only enter positive integers. For the at-bat
        // results, the user can only enter 0, 1, 2, 3, or 4


        //Format the batting average and slugging percentages such that three decimal places
        System.out.println("Thank you!");
        scan.close();
    }

    public static void getBat(Scanner scan){
        String repeatAvg = "y";

        while (repeatAvg.equalsIgnoreCase("y")){
            getAvg(scan);
            do {
                System.out.println("Do you want another batter? Enter: y or n?");
                 repeatAvg = scan.next();
                if (!(repeatAvg.equalsIgnoreCase("y") || repeatAvg.equalsIgnoreCase("n"))) {
                    System.out.println("Your input is not valid");
                }
            }while (!(repeatAvg.equalsIgnoreCase("y") || repeatAvg.equalsIgnoreCase("n")));
        }

    }
    public static void getAvg(Scanner scan){
        int sumBases = 0;
        System.out.println("Enter number of times at bat:");

        while(!scan.hasNextInt()) {
            System.out.println("Not a number!");
            scan.nextLine();
        }
        int numBats = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the at bat results:");
        int[] atBats = new int[numBats];
        int hits = 0;
        for(int i = 0; i < atBats.length; i++) {
            int bases;
            do {
                while(!scan.hasNextInt()) {
                    System.out.println("Not a number!");
                    scan.nextLine();
                }
                bases = scan.nextInt();
                scan.nextLine();
                if (bases < 0 || bases > 4) {
                    System.out.println("Invalid number. Please try again!");
                }
            } while(bases < 0 || bases > 4);
            sumBases += bases;
            if(bases > 0){
                hits++;
            }
            System.out.println("Result for at-bat " + i + ": " + bases);
        }
        double slugPercent = ((double) sumBases / numBats);
        double avg = ((double) hits / numBats);
        System.out.printf("The batting average: %.3f\n",  avg);
        System.out.printf("The slugging percentage: %.3f\n", slugPercent);

    }
}
