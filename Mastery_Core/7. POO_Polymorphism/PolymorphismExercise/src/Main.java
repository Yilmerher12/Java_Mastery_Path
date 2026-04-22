import java.util.ArrayList;
import java.util.List;

/**
 * MODULE 7: POLYMORPHISM PRACTICAL EXERCISE
 * This file demonstrates Upcasting, Downcasting, Instanceof,
 * Dynamic Binding (Overriding), and Static Binding (Overloading).
 */

// Parent Class (Superclass)
class Dispositivo {
    private String nombre;

    public Dispositivo(String nombre) {
        this.nombre = nombre;
    }

    // METHOD TO BE OVERRIDDEN (Dynamic Polymorphism)
    public void operar() {
        System.out.println("Operating generic device: " + nombre);
    }

    // OVERLOADED METHOD (Static Polymorphism - Compiled Time)
    // Same name, different parameters. Decisions happen in the Stack.
    public void operar(int intensity) {
        System.out.println("Operating " + nombre + " at intensity level: " + intensity);
    }

    public String getNombre() {
        return nombre;
    }
}

// Child Class 1
class Sensor extends Dispositivo {
    public Sensor(String nombre) {
        super(nombre);
    }

    @Override
    public void operar() {
        // Dynamic Binding: JVM will look for this version in the Metaspace/V-Table
        System.out.println("[Sensor] Scanning environment...");
    }

    // Specific Method (Unique to Sensor)
    public void medirTemperatura() {
        System.out.println("[Sensor] Current Temperature: 25°C");
    }
}

// Child Class 2
class Actuador extends Dispositivo {
    public Actuador(String nombre) {
        super(nombre);
    }

    @Override
    public void operar() {
        System.out.println("[Actuator] Executing mechanical movement...");
    }

    // Specific Method (Unique to Actuator)
    public void detenerEmergencia() {
        System.out.println("[Actuator] !!! EMERGENCY STOP ACTIVATED !!!");
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. UPCASTING: Storing different child objects in a Parent-type list.
        // This provides flexibility but hides child-specific methods.
        List<Dispositivo> inventory = new ArrayList<>();

        inventory.add(new Sensor("Thermal_Sensor_01"));
        inventory.add(new Actuador("Hydraulic_Arm_02"));

        System.out.println("--- STARTING INDUSTRIAL CONTROL SYSTEM ---");

        for (Dispositivo d : inventory) {
            System.out.println("\nProcessing device: " + d.getNombre());

            /* * 2. DYNAMIC BINDING (Method Overriding)
             * Even though 'd' is a 'Dispositivo' reference (the mask),
             * the JVM jumps to the Heap, checks the Klass Pointer,
             * and executes the specific version of operar().
             */
            d.operar();

            /* * 3. THE "INSTANCEOF" OPERATOR (The DNA Scanner)
             * We check the real identity of the object in the Heap before
             * trying to change its "mask" in the Stack.
             */
            if (d instanceof Sensor) {
                // 4. DOWNCASTING (Manual Casting)
                // We manually tell the compiler: "Trust me, this is a Sensor".
                // This allows us to access specific methods hidden by the parent mask.
                Sensor s = (Sensor) d;
                s.medirTemperatura();
            }
            else if (d instanceof Actuador) {
                // Downcasting directly in one line
                ((Actuador) d).detenerEmergencia();
            }

            // 5. STATIC BINDING (Method Overloading)
            // The compiler decides to call this version because of the (int) parameter.
            d.operar(10);
        }
    }
}