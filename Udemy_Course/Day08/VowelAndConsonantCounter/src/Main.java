import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Step 1: Declare and initialize Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        int vowels = 0, consonants = 0;
        String vowelsList = "aeiouAEIOU";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            System.out.println("Do you want to continue? (yes to continue, no to exit)");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("no")) {
                break;
            }

            if (!Character.isLetter(ch)) {
                continue;
            }

            if (vowelsList.indexOf(ch) != -1) {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Total vowels: " + vowels);
        System.out.println("Total consonants: " + consonants);

        scanner.close();
        }
    }