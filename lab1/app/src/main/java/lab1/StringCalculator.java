package lab1;

import java.util.Scanner;

public class StringCalculator {
     java.lang.Integer add(String numbers) throws Exception { 

        if (numbers.length() > 0) {

            String[] splittedList = null;
            splittedList = numbers.split(",");
            if (splittedList.length > 2) {
                System.out.printf("More than 2 numbers are not alowed!\n"); 
                return null;
            } 

            int accumulator = 0;
            for (String element : splittedList){
                try {
                    accumulator += Integer.parseInt(element);
                }
                catch (NumberFormatException e) {
                    System.out.printf("Something went wrong! '%s' is not an integer.\n", numbers); 
                    return null;
                }
                
            }
            return accumulator;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.printf("======== LAB 1 ==========\n");
        try (Scanner myscan = new Scanner(System.in)) {
            System.out.print("\nEnter 2 or less numbers separated by comma: "); 
            String mystr = myscan.nextLine(); 
            Integer sum = new StringCalculator().add(mystr);
            if (sum != null)
                System.out.println("Your answer: \n" + sum);
        } 
        System.out.println("\n=====================\n"); 
    }
}