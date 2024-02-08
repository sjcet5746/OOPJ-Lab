import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns for the first matrix:");
        int m1 = scanner.nextInt();
        int n1 = scanner.nextInt();

        System.out.println("Enter the number of rows and columns for the second matrix:");
        int m2 = scanner.nextInt();
        int n2 = scanner.nextInt();

        if (n1 != m2) {
            System.out.println("Matrix multiplication not possible! Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return;
        }

        int[][] matrix1 = new int[m1][n1];
        int[][] matrix2 = new int[m2][n2];
        int[][] result = new int[m1][n2];

        System.out.println("Enter the elements of the first matrix:");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of the second matrix:");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Performing matrix multiplication
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Resultant matrix after multiplication:");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
