import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Inicializar arreglos para almacenar detalles de los astronautas
        String[] astronautNames = new String[10]; // Máximo 10 astronautas
        int[] astronautAges = new int[10];
        String[] missionStatus = new String[10];
        int numAstronauts = 0; // Seguimiento del número de astronautas

        while (true) {
            // Paso 2: Mostrar opciones del menú
            System.out.println("--- Menú de Misión Espacial ---");
            System.out.println("1. Añadir astronauta a la misión");
            System.out.println("2. Actualizar estado de misión de un astronauta");
            System.out.println("3. Mostrar todos los astronautas");
            System.out.println("4. Salir");
            System.out.print("Ingrese su elección: ");

            // Paso 3: Leer elección del usuario
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            // Paso 4: Implementar switch para diferentes operaciones
            switch (choice) {
                case 1:
                    if (numAstronauts < 10) {
                        System.out.print("Nombre del astronauta: ");
                        astronautNames[numAstronauts] = scanner.nextLine();

                        System.out.print("Edad del astronauta: ");
                        astronautAges[numAstronauts] = scanner.nextInt();
                        scanner.nextLine(); // Consumir nueva línea

                        System.out.print("Estado (En misión / Disponible): ");
                        missionStatus[numAstronauts] = scanner.nextLine();
                        numAstronauts++;
                        System.out.println("Astronauta añadido con éxito.");
                    } else {
                        System.out.println("Error: Capacidad máxima de astronautas alcanzada.");
                    }
                    break;

                case 2:
                    System.out.print("Nombre del astronauta para actualizar: ");
                    String nameToSearch = scanner.nextLine();
                    boolean found = false;

                    for (int i = 0; i < numAstronauts; i++) {
                        // Se utiliza .equalsIgnoreCase para comparar contenido de strings sin importar mayúsculas
                        if (astronautNames[i].equalsIgnoreCase(nameToSearch)) {
                            System.out.print("Nuevo estado (En misión / Disponible): ");
                            missionStatus[i] = scanner.nextLine();
                            System.out.println("Estado actualizado para " + astronautNames[i]);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Astronauta no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Lista de Astronautas ---");
                    // Se verifica si el contador es 0
                    if (numAstronauts == 0) {
                        System.out.println("No hay astronautas registrados.");
                    } else {
                        for (int i = 0; i < numAstronauts; i++) {
                            System.out.println("ID: " + (i + 1) + " | Nombre: " + astronautNames[i] +
                                    " | Edad: " + astronautAges[i] +
                                    " | Estado: " + missionStatus[i]);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa. ¡Buen viaje, comandante!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente del 1 al 4.");
            }
            System.out.println(); // Salto de línea para legibilidad
        }
    }
}