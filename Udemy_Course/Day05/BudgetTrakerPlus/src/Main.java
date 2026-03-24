import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Step 1: Declare and initialize Scanner
        Scanner scanner = new Scanner(System.in);

        // Step 2: Prompt user for monthly income
        System.out.print("Enter your monthly income: $");
        double income = scanner.nextDouble();

        // Step 3: Prompt user for various expenses
        System.out.print("Enter your monthly rent: $");
        double rent = scanner.nextDouble();

        System.out.print("Enter your monthly groceries expense: $");
        double groceries = scanner.nextDouble();

        System.out.print("Enter your monthly transportation expense: $");
        double transportation = scanner.nextDouble();

        System.out.print("Enter your monthly entertainment expense: $");
        double entertainment = scanner.nextDouble();

        // Step 4: Calculate total expenses
        double totalExpenses = rent + groceries + transportation + entertainment;

        // Step 5: Calculate remaining budget
        double remainingBudget = income - totalExpenses;

        // Step 6: Calculate percentage spent per category
        double rentPercentage = (rent / income) * 100;
        double groceriesPercentage = (groceries / income) * 100;
        double transportationPercentage = (transportation / income) * 100;
        double entertainmentPercentage = (entertainment / income) * 100;

        // Step 7: Display formatted budget summary
        System.out.println("\n********** Budget Summary **********");
        System.out.printf("Monthly Income: $%.2f\n", income);
        System.out.printf("Total Expenses: $%.2f\n", totalExpenses);
        System.out.printf("Remaining Budget: $%.2f\n", remainingBudget);

        System.out.println("Expenses Breakdown:");
        System.out.printf("  Rent: $%.2f (%.2f%% of income)\n", rent, rentPercentage);
        System.out.printf("  Groceries: $%.2f (%.2f%% of income)\n", groceries, groceriesPercentage);
        System.out.printf("  Transportation: $%.2f (%.2f%% of income)\n", transportation, transportationPercentage);
        System.out.printf("  Entertainment: $%.2f (%.2f%% of income)\n", entertainment, entertainmentPercentage);
        System.out.println("************************************");

        // Close Scanner
        scanner.close();
    }
}