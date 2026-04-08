import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialization of the Scanner object in the Heap
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an email address to validate:");

        // scanner.nextLine() reads the buffer until a newline character
        String email = scanner.nextLine();

        // Control flow: the result of isValidEmail(email) determines which branch executes
        if (isValidEmail(email)) {
            System.out.println("The email address is valid.");
        } else {
            System.out.println("The email address is invalid.");
        }

        scanner.close(); // Releases the resource pointer
    }

    /**
     * Validates the email address based on predefined rules.
     */
    public static boolean isValidEmail(String email) {
        // RULE 1: Exactly one '@' symbol
        int atSymbolCount = 0;

        // Loop iterates through the char array of the String in memory
        for (int i = 0; i < email.length(); i++) {
            // email.charAt(i) accesses the specific index in the String's internal array
            if (email.charAt(i) == '@') {
                atSymbolCount++;
            }
        }

        // If atSymbolCount is not exactly 1, the method hits a 'return'
        // This causes an immediate exit from the method (Stack Frame pop)
        if (atSymbolCount != 1) {
            return false;
        }

        // RULE 2: Characters must exist before and after '@'
        // email.indexOf('@') returns the int index of the first occurrence
        int atIndex = email.indexOf('@');

        // atIndex < 1: Checks if '@' is at the very start (index 0)
        // atIndex == email.length() - 1: Checks if '@' is the very last character
        if (atIndex < 1 || atIndex == email.length() - 1) {
            return false;
        }

        // RULE 3: Verify at least one '.' after the '@'
        // email.substring(atIndex + 1) creates a NEW String object in the Heap
        // representing everything after the '@'
        String domainPart = email.substring(atIndex + 1);

        // .contains(".") checks the sequence of chars in the domainPart
        if (!domainPart.contains(".")) {
            return false;
        }

        // RULE 4: '.' cannot be the first or last character of the domainPart
        int dotIndex = domainPart.indexOf('.');
        if (dotIndex < 1 || dotIndex == domainPart.length() - 1) {
            return false;
        }

        // RULE 5: No spaces allowed anywhere in the string
        if (email.contains(" ")) {
            return false;
        }

        // If the execution reaches this point, no 'return false' was triggered
        return true;
    }
}