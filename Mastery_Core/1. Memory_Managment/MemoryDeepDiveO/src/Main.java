//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Primitive: Stored directly in the Main Thread Stack
        int age = 21;

        // String Literal: Stored in String Pool (e.g., Address 0x111)
        String cityA = "Bogotá";

        // String Literal: Reuses Address 0x111 from the Pool
        String cityB = "Bogotá";

        // 'new' keyword: Forces creation in General Heap (Address 0x999)
        String cityC = new String("Bogotá");

        // MEMORY VERIFICATION
        // (cityA == cityB) -> true: Both variables in Stack hold address 0x111
        // (cityA == cityC) -> false: 0x111 is not equal to 0x999
        // (cityA.equals(cityC)) -> true: The data content matches.

        System.out.println(cityA == cityB);
        System.out.println(cityA == cityC);
        System.out.println(cityC == cityB);
    }
}