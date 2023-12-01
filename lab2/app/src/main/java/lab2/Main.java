package lab2;

public class Main {
    public static void main(String[] args) {
        // Приклад використання класу
        Matrix matrix1 = new Matrix(new double[][]{{3, 0, 8}, {1, 8, -6}, {-1, 8, 9}});
        Matrix matrix2 = new Matrix(new double[][]{{0, 2, 3}, {4, 0, 6}, {7, 8, 0}});
        Matrix matrix4 = new Matrix(new double[][]{{0, 2, 3}, {4, 0, 6}, {7, 8, 0}, {-1, 8, 9}});

        Matrix empty = new Matrix();
        Matrix value = new Matrix(2,3);
        value.fill(1);
        Matrix matrix3 = matrix1.copy();

        System.out.println("Emty matrix:\n" + empty);
        System.out.println("Matrix 1:\n" + matrix1);
        System.out.println("Matrix 2:\n" + matrix2);
        System.out.println("Matrix 3 (copy of Matrix 1):\n" + matrix3);
        System.out.println("\nElement of matrix 2: "+ matrix2.getElement(2,2));
        //виведення рядка матриці
        int rowIndex = 1;
        double[] row = matrix2.getRow(rowIndex);
        System.out.print("Matrix 2 Row " + rowIndex + ": ");
        for (double val : row) {
            System.out.print(val + " ");
        }
        //виведення стовпця матриці
        int colIndex = 0;
        double[] column = matrix3.getCol(colIndex);
        System.out.print("\nMatrix 3 Column " + colIndex + ": ");
        for (double val : column) {
            System.out.print(val + " ");
        }
        //Розмірність матриці
        System.out.println("\nSize of matrix 2: "+ matrix2.getSize()[0] + "*" + matrix2.getSize()[1]);
        System.out.println("Size of matrix 4: "+ matrix4.getSize()[0] + "*" + matrix4.getSize()[1]); 
        //Хеш код
        System.out.println("Hash code of matrix 1: " + matrix1.hashCode());
        System.out.println("Hash code of matrix 2: " + matrix2.hashCode());
        System.out.println("Hash code of matrix 3: " + matrix3.hashCode());
        System.out.println("Hash code of matrix 4: " + matrix4.hashCode());
        //перевірка чи дві матриці рівні
        System.out.println("Matrix 1 equals Matrix 3: " + matrix1.equals(matrix3));
        System.out.println("Matrix 1 equals Matrix 4: " + matrix1.equals(matrix4));
        // Незмінна матриця
        ImmutableMatrix iMatrix = new ImmutableMatrix(matrix2);
        ImmutableMatrix iMatrix2 = new ImmutableMatrix(new double[][]{{0, 2, 3}, {4, 0, 6}, {7, 8, 0}, {-1, 8, 9}});
        System.out.println("Immutable Matrix 1:\n" + iMatrix);
        System.out.println("Hash code of immutable matrix 2: " + iMatrix2.hashCode());
        System.out.println("Immutable matrix equals Matrix 2: " + iMatrix.equals(matrix2));
        System.out.println("Matrix 2 equals immutable matrix by value: " + matrix2.equals(iMatrix));
    }
}
