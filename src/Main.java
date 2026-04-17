//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int number = 10;
        User myUser = new User("Original");
        String text = "Java";

        executeTest(number, myUser, text);

        System.out.println("1. Primitive: " + number);
        System.out.println("2. Object Name: " + myUser.getName());
        System.out.println("3. String: " + text);
    }

    public static void executeTest(int n, User u, String s) {
        n = 50;                  // Change local primitive copy
        u.setName("Changed");    // Follow address to Heap and mutate
        u = new User("New");     // Reassign local address copy
        s = "Updated";           // Reassign local string address
    }
}