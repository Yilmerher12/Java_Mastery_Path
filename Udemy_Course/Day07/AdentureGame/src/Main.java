import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Ultimate Adventure Game!");
        System.out.println("Your goal is to find the hidden treasure. Choose wisely!");

        System.out.println("\nYou are at a crossroad. Do you want to go left or right?");
        System.out.print("Type 'left' or 'right': ");
        String choice1 = scanner.nextLine().toLowerCase();

        switch (choice1) {
            case "left":
                System.out.println("\nYou walk down a dark path and find a mysterious cave.");
                System.out.println("Do you want to enter the cave or walk past it?");
                System.out.print("Type 'enter' or 'walk': ");
                String choice2 = scanner.nextLine().toLowerCase();

                switch (choice2) {
                    case "enter":
                        System.out.println("\nInside the cave, you find a sleeping dragon!");
                        System.out.println("Do you want to fight the dragon or sneak past it?");
                        System.out.print("Type 'fight' or 'sneak': ");
                        String choice3 = scanner.nextLine().toLowerCase();

                        switch (choice3) {
                            case "fight":
                                System.out.println("\nYou bravely fight the dragon and...");
                                System.out.println("You are victorious! The dragon guards the treasure. You win!");
                                break;
                            case "sneak":
                                System.out.println("\nYou sneak past the dragon and find the treasure behind it. You win!");
                                break;
                            default:
                                System.out.println("\nInvalid choice. You got caught by the dragon and lost.");
                                break;
                        }
                        break;
                    case "walk":
                        System.out.println("\nYou walk past the cave and fall into a hidden trap. Game over.");
                        break;
                    default:
                        System.out.println("\nInvalid choice. You got lost in the wilderness. Game over.");
                        break;
                }
                break;
            case "right":
                System.out.println("\nYou walk through a dense forest and find a river.");
                System.out.println("Do you want to swim across or build a raft?");
                System.out.print("Type 'swim' or 'raft': ");
                String choice2b = scanner.nextLine().toLowerCase();

                switch (choice2b) {
                    case "swim":
                        System.out.println("\nYou swim across the river and encounter a wild bear!");
                        System.out.println("Do you want to run away or climb a tree?");
                        System.out.print("Type 'run' or 'climb': ");
                        String choice3b = scanner.nextLine().toLowerCase();

                        switch (choice3b) {
                            case "run":
                                System.out.println("\nYou run away safely and find a hidden path to the treasure. You win!");
                                break;
                            case "climb":
                                System.out.println("\nYou climb the tree, but the bear waits for you. You are stuck. Game over.");
                                break;
                            default:
                                System.out.println("Invalid choice. The bear catches you. Game over.");
                                break;
                        }
                        break;
                    case "raft":
                        System.out.println("\nYou build a raft and safely cross the river. You find the treasure on the other side. You win!");
                        break;
                    default:
                        System.out.println("\nInvalid choice. You got swept away by the river. Game over.");
                        break;
                }
                break;
            default:
                System.out.println("\nInvalid choice. You got lost in the wilderness. Game over.");
                break;
        }

        scanner.close();
    }
}

