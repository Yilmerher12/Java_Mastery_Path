/**
 * SENA - ADSO | CGI Mentorship
 * Module 4: Wrapper Classes, Autoboxing, and Memory Performance
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. The Integer Cache Neighborhood (-128 to 127)
        Integer cacheA = 127;
        Integer cacheB = 127;
        System.out.println("Shared Cache Address: " + (cacheA == cacheB)); // true

        Integer newA = 128;
        Integer newB = 128;
        System.out.println("Independent Heap Address: " + (newA == newB)); // false

        // 2. The Unboxing Comparison Mechanism
        int primitive = 128;
        // Even if 128 is outside the cache, this is true because of Unboxing
        System.out.println("Value Comparison via Unboxing: " + (newA == primitive)); // true

        // 3. The Performance Nightmare (Immutability in Loops)
        Long sum = 0L;
        for (int i = 0; i < 100; i++) {
            // Each iteration: Unboxes 'sum', adds 'i', Autoboxes result into a NEW Object
            // This creates 100 temporary objects in the Heap
            sum = sum + i;
        }
        System.out.println("Final Sum: " + sum);

        // 4. The Null Safety Risk
        try {
            Integer databaseCount = null;
            int count = databaseCount; // ERROR: Implicit call to .intValue() on null
        } catch (NullPointerException e) {
            System.out.println("Safe Catch: Cannot unbox a null address into the Stack.");
        }

        /*OUTPUT RESULT
        Shared Cache Address: true
        Independent Heap Address: false
        Value Comparison via Unboxing: true
        Final Sum: 4950
        Safe Catch: Cannot unbox a null address into the Stack.*/
    }
}