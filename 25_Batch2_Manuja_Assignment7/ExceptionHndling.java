// Author: Manuja Nagvekar
// Roll No.: 25
// Title: Exception Handling in Java
// Description: This program demonstrates exception handling by performing division. 


import java.util.Scanner;

public class ExceptionHndling {


    public static double divide(int numerator, int denominator) {
        return numerator / denominator; 
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            double result = divide(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            System.out.println("Execution completed.");
            scanner.close();
        }
    }
}
