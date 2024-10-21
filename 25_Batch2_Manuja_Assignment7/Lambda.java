// Author: Manuja Nagvekar
// Roll No.: 25
// Title: Lambda Expression for Addition
// Description: This program demonstrates the use of a lambda expression 
// to implement the Adder interface, which defines a method to add 
// three integers. The lambda expression is used to calculate the sum 
// of three numbers and print the result.

interface Adder {
    int add(int a, int b, int c);
}

public class Lambda {
    public static void main(String[] args) {
        
        // Lambda expression to implement the add method of Adder interface
        Adder adder = (a, b, c) -> a + b + c;

        // Calculate the sum of the numbers
        int result = adder.add(10, 20, 30);
        System.out.println("Sum of numbers: " + result);
    }
}
