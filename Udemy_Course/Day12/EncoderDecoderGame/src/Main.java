import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Encoder-Decoder Game!");
        System.out.println("1. Encode a string");
        System.out.println("2. Decode a string");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        if (choice == 1) {
            String encodedString = encode(input, 0);
            System.out.println("Encoded string: " + encodedString);
        } else if (choice == 2) {
            String decodedString = decode(input, 0);
            System.out.println("Decoded string: " + decodedString);
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    public static String encode(String input, int index) {
        if (index == input.length()) {
            return "";
        }
        char ch = input.charAt(index);
        char encodedChar = atbash(ch);
        return encodedChar + encode(input, index + 1);
    }

    public static String decode(String input, int index) {
        return encode(input, index);
    }

    public static char atbash(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) ('z' - (ch - 'a'));
        } else if (ch >= 'A' && ch <= 'Z') {
            return (char) ('Z' - (ch - 'A'));
        } else {
            return ch;
        }
    }
}