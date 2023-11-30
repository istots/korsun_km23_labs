package lab2;

public class Main {
    public static void main(String[] args) {
        // Приклад використання класу
        Matrix matrix1 = new Matrix(new double[][]{{3, 0, 8}, {1, 8, -6}, {-1, 8, 9}});
        Matrix matrix2 = new Matrix(new double[][]{{0, 2, 3}, {4, 0, 6}, {7, 8, 0}});

        Matrix empty = new Matrix();
        Matrix value = new Matrix(2,3);
        value.fill(1);
        Matrix matrix3 = matrix1.copy();

        System.out.println("Emty matrix: " + empty);
        System.out.println("Matrix 1:\n" + matrix1);
        System.out.println("Matrix 2:\n" + matrix2);
        System.out.println("Matrix 3 (copy of Matrix 1):\n" + matrix3);
    }
}
