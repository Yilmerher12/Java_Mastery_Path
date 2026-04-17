//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// ANATOMY OF THE INSTANCE
        // Reference (Mask) = Component
        // Object (Reality) = Sensor
        Component myItem = new Sensor();

        // TEST 1: ATTRIBUTES (Shadowing)
        // Java looks at the Reference (Component), so it sees "OFFLINE"
        System.out.println("Reading attribute directly: " + myItem.status);

        // TEST 2: METHODS (Overriding)
        // Java looks at the Reality (Sensor), so it runs the Child's code
        myItem.check();

        // TEST 3: PERMISSIONS
        // myItem.onlySensorCanDoThis();
        // ERROR! The "Mask" is Component, and Components don't know how to scan.

        // TEST 4: REMOVING THE MASK (Casting)
        ((Sensor) myItem).onlySensorCanDoThis(); // Now it works!
    }
}

// 1. Parent Class
class Component {
    // Parent's version of the attribute
    public String status = "OFFLINE";

    public void check() {
        System.out.println("Status according to Parent: " + this.status);
    }
}

// 2. Child Class
class Sensor extends Component {
    // Attribute Shadowing: A new variable with the same name
    public String status = "ONLINE";

    @Override
    public void check() {
        // This method will use the Child's attribute because it's inside the Child class
        System.out.println("Status according to Child: " + this.status);
    }

    public void onlySensorCanDoThis() {
        System.out.println("Scanning frequencies...");
    }
}