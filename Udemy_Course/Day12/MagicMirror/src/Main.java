import java.util.Scanner;

public class Main {
    // Recursive method to reverse a string
    public static String reverseString(String str) {
        // Base case: If the string is empty or has one character, return the string
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        /*
         * Recursive case:
         * Take the last character and add it to the reversed rest of the string.
         * The call to str.substring(0, str.length() - 1) creates a shorter string
         * by removing the last character, so each recursive call works with a
         * smaller string until eventually the base case is reached.
         */
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a string
        System.out.println("Enter a string to reflect in the magic mirror:");
        String inputString = scanner.nextLine();

        // Reverse the string using the recursive method
        String reversedString = reverseString(inputString);

        // Print the reversed string
        System.out.println("The magic mirror reflects: " + reversedString);

        scanner.close();
    }
}