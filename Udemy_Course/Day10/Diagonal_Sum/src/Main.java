import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Request matrix size / Solicitar tamaño (n x n)
        System.out.print("Enter matrix size: ");
        int n = scanner.nextInt();
        //Declare the matrix (row)(columns)
        int[][] mat = new int[n][n];

        // Fill the matrix / Llenado de la estructura de datos
        System.out.println("Enter the elements:");

        // The following structure runs the matrix and put the value of each one
        // Runs Each row
        for (int i = 0; i < n; i++) {
            //Runs each column
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;

        /* * Optimization: Using a single loop (O(n)) instead of nested loops (O(n^2))
         * Optimización: Uso de un solo ciclo para evitar recorrer elementos innecesarios
         */
        for (int i = 0; i < n; i++) {
            // Primary diagonal: row and column are equal (i, i)
            // Diagonal primaria: el índice de fila y columna coinciden
            sum += mat[i][i];

            // Secondary diagonal: row 'i', column 'n - 1 - i'
            // Diagonal secundaria: el índice inverso de la columna respecto a la fila
            int secondaryCol = n - 1 - i;

            /* * Edge case: If n is odd, the middle element is shared by both diagonals.
             * Caso límite: Si n es impar, el centro se comparte; solo se suma una vez.
             */
            if (i != secondaryCol) {
                sum += mat[i][secondaryCol];
            }
        }

        System.out.println("Total diagonal sum: " + sum);

        /*
         * STEP-BY-STEP PROCESS / PROCESO PASO A PASO (Example 3x3 Matrix):
         * Matrix:
         * [10, 20, 30]
         * [40, 50, 60]
         * [70, 80, 90]
         * * 1. Iteration i=0:
         * - Primary: mat[0][0] = 10. Sum = 10.
         * - Secondary: mat[0][2] = 30. (0 != 2) -> Sum = 10 + 30 = 40.
         * * 2. Iteration i=1:
         * - Primary: mat[1][1] = 50. Sum = 40 + 50 = 90.
         * - Secondary: mat[1][1] = 50. (1 == 1) -> SKIP (Already added).
         * * 3. Iteration i=2:
         * - Primary: mat[2][2] = 90. Sum = 90 + 90 = 180.
         * - Secondary: mat[2][0] = 70. (2 != 0) -> Sum = 180 + 70 = 250.
         * * Final Output: 250.
         */

        scanner.close();
    }
}
