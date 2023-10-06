package lab1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
     java.lang.Integer add(String numbers) throws Exception { 

        if (numbers.length() > 0) {

            if (numbers.endsWith("\\n")) {
                System.out.printf("Something went wrong! '%s' is invalid.", numbers); 
                return null;
            }
            //задаємо користувацький роздільник
            String delimiter = ",";
            Pattern pattern = Pattern.compile("//(.*?)\\\\n(.*)");
            Matcher matcher = pattern.matcher(numbers);
            if (matcher.find()) {
                delimiter = matcher.group(1);
                numbers = matcher.group(2).replace(delimiter, ",");
            }

            String[] splittedList = null;
            splittedList = numbers.split(",|\\\\n");


            ArrayList<Integer> numberList = new ArrayList<Integer>();

            int accumulator = 0;
            for (String element : splittedList){
                try {
                    accumulator += Integer.parseInt(element);
                }
                catch (NumberFormatException e) {
                    System.out.printf("Something went wrong! '%s' is not an integer.\n", numbers); 
                    return null;
                }
                if (Integer.valueOf(element) < 0) {//записуємо негативні числа в список
                    numberList.add(Integer.valueOf(element));
                }
                if (Integer.valueOf(element) > 1000) { //ігноруємо елементи більше 1000
                    accumulator -= Integer.parseInt(element);
                    continue;
                }
            }
            if (numberList.size() > 0) {// обмеження на негативні числа
                System.out.println("Negatives are not allowed!");
                for (Integer number : numberList) {
                    System.out.println(number);
                }
                return null;
            }
            return accumulator;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.printf("======== LAB 1 ==========\n");
        try (Scanner myscan = new Scanner(System.in)) {
            System.out.print("\nEnter numbers separated by commas or \\n: "); 
            String mystr = myscan.nextLine(); 
            Integer sum = new StringCalculator().add(mystr);
            if (sum != null)
                System.out.println("Your answer: " + sum);
        } 
        System.out.println("\n=====================\n"); 
    }
}