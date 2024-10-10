import java.util.Scanner;

/**
 * Author: Manuja Nagvekar
 * Roll No: 25
 * Title: Magic Math Game
 * Description: The MagicMathGame class implements a simple text-based game that
 * presents mathematical tricks to the user. It allows the user to perform
 * operations on numbers and demonstrates some mathematical principles 
 * through engaging tricks.
 */
public class MagicMathGame {

    /**
     * The main method prompts the user to play the math game and
     * initiates the guessing game if the user agrees.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        System.out.print("Do you want to play Math tricks? (Y/N): ");
        String answer1 = choice.nextLine();

        if ("y".equals(answer1) || "Y".equals(answer1)) {
            guessNumber();
        } else {
            System.out.println("Goodbye!");
        }
    }

    /**
     * This method guides the user through a series of mathematical operations
     * and reveals the final result of the trick.
     */
    private static void guessNumber() {
        System.out.println("\n-----I can guess your final result-----");
        System.out.println("Steps:\nThink of a number between (1-10).");
        System.out.println("1) Multiply it by 2.");
        System.out.println("2) Add 8 to the result.");
        System.out.println("3) Divide the result by 2.");
        System.out.println("4) Subtract the result with the number you chose.");
        System.out.println("5) THE FINAL ANSWER WILL BE 4.");

        Scanner obj1 = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int num = obj1.nextInt();

        int mulnum = num * 2;
        int addnum = mulnum + 8;
        int divnum = addnum / 2;
        int subnum = divnum - num;

        System.out.println("\nThe final answer is:\n" + num + " * 2 = " + mulnum + " ,\n" + mulnum + " + 8 = " + addnum + ",\n" + addnum + "/ 2 = " + divnum + ",\n" + divnum + " - " + num + " = " + subnum);
        System.out.println("And the result is " + subnum);

        System.out.print("\nWant to play one more? (Y/N): ");
        Scanner obj2 = new Scanner(System.in);
        String answer2 = obj2.nextLine();

        if ("y".equals(answer2) || "Y".equals(answer2)) {
            trick9();
        } else {
            System.out.println("Goodbye!");
        }
    }

    /**
     * This method explains the 9 multiplication trick and calculates the result
     * based on user input. It prompts the user to pick a number, multiply it by 9,
     * and then add the digits of the resulting number.
     */
    private static void trick9() {
        Scanner obj1 = new Scanner(System.in);
        System.out.println("\n-----The 9 Multiplication Trick-----");
        System.out.println("Steps:");
        System.out.println("1) Pick any number from (2-10).");
        System.out.println("2) Now multiply the number by 9.");
        System.out.println("3) Now add the digits of the result together.");
        System.out.println("4) If the sum is not a single digit, repeat the process until it is.");
        System.out.println("5) THE FINAL ANSWER WILL ALWAYS BE 9.");

        System.out.print("Enter any number: ");
        int num = obj1.nextInt();
        int resu = num * 9;
        int sum = sumOfDigits(resu);

        System.out.println("\nThe final answer is: \n" + num + " * 9 = " + resu + ",");
        System.out.print("\nThen the sum of " + resu + " is: " + sum);
    }

    /**
     * This method calculates the sum of the digits of a given number.
     *
     * @param numberr the number for which the digit sum will be calculated.
     * @return the sum of the digits of the given number.
     */
    public static int sumOfDigits(int numberr) {
        int summ = 0;
        while (numberr != 0) {
            summ = summ + numberr % 10;
            numberr = numberr / 10;
        }
        return summ;
    }
}
