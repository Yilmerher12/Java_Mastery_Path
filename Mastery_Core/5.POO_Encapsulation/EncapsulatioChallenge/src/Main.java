//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] originalPines = {1234, 5678, 9012};

        // 2. Create the Encapsulated Object
        Vault myVault = new Vault(originalPines);

        // --- ATTACK 1: Modifying the input after creation ---
        originalPines[0] = 0000;
        // If the constructor is secure, myVault.data[0] is still 1234.

        // --- ATTACK 2: Modifying the data via the Getter ---
        int[] leakedData = myVault.getPines();
        leakedData[1] = 9999;
        // If the getter is secure, myVault.data[1] is still 5678.

        // 3. Final Verification
        System.out.println("=== Vault Integrity Report ===");
        myVault.printStatus();
    }
    }

/**
 * The "Bunker" Class.
 * Uses private attributes and defensive copying to protect the Heap state.
 */
class Vault {
    // Implementation: Private state in the Heap
    private final int[] pines;

    // CONSTRUCTOR: Defensive Copy (Entry Gate)
    public Vault(int[] incomingPines) {
        // Instead of this.pines = incomingPines (Sharing address),
        // we create a NEW address in the Heap and copy the values.
        if (incomingPines != null) {
            this.pines = incomingPines.clone();
        } else {
            this.pines = new int[0];
        }
    }

    // GETTER: Defensive Copy (Exit Gate)
    public int[] getPines() {
        // We never return the actual reference.
        // We return a 'Photocopy' (New Address, Same Values).
        return (this.pines != null) ? this.pines.clone() : null;
    }

    // A method to prove the internal state remains untouched.
    public void printStatus() {
        System.out.print("Internal Heap Values: ");
        for (int p : this.pines) {
            System.out.print("[" + p + "] ");
        }
        System.out.println("\nStatus: " + (isVulnerable() ? "VULNERABLE" : "SECURE"));
    }

    private boolean isVulnerable() {
        // Internal check for common attack values
        for (int p : pines) {
            if (p == 0 || p == 9999) return true;
        }
        return false;
    }
}
