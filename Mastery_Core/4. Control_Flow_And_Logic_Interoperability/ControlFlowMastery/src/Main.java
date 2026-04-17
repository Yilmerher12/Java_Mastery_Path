//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        testShortCircuit(null);
        handleSwitch("MEDIUM");
        demonstrateLoopControl();
    }

    // 1. Short-circuiting and Null Protection
    public static void testShortCircuit(String input) {
        System.out.println("--- Short-Circuit Test ---");
        // Protection: If input is null, it never reaches .toUpperCase()
        if (input != null && input.toUpperCase().equals("JAVA")) {
            System.out.println("Match found!");
        } else {
            System.out.println("Safe: No crash occurred.");
        }
    }

    // 2. Modern Switch with Yield
    public static void handleSwitch(String level) {
        System.out.println("\n--- Modern Switch Test ---");
        int numericLevel = switch (level) {
            case "HIGH" -> 1;
            case "MEDIUM" -> {
                System.out.println("Processing medium priority...");
                yield 2;
            }
            default -> 3;
        };
        System.out.println("Assigned Level: " + numericLevel);
    }

    // 3. Loop Control: Break and Continue
    public static void demonstrateLoopControl() {
        System.out.println("\n--- Loop Control Test ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // Skip even numbers
            if (i > 7) break;         // Stop loop if i is greater than 7
            System.out.println("Odd number: " + i);
        }
    }
}