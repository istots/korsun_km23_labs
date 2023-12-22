package lab2;

public class Main {
    public static void main(String[] args) {
        // Приклад використання класу
        Matrix matrix1 = new Matrix(new double[][]{{3, 0, 8}, {1, 8, -6}, {-1, 8, 9}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 2, 3}, {4, 0, 6}, {7, 8, -1}});
        
        Matrix matrix4 = new Matrix(new double[][]{{9, 2, 3}, {4, 25, 0}, {7, 8, 0}, {-1, 8, 9}});

        Matrix empty = new Matrix();
        Matrix value = new Matrix(2,3);
        value.fill(1);
         Matrix value2 = new Matrix(4,3);
        value2.fill(1);
        Matrix matrix3 = matrix2.copy();
        ImmutableMatrix Imatix = new ImmutableMatrix(matrix3);
        System.out.println("matrix 3:\n" + matrix3);
        System.out.println("Imatrix:\n" + Imatix);



        System.out.println("Emty matrix:\n" + empty);
        System.out.println("Matrix 1:\n" + matrix1);
        System.out.println("Matrix 2:\n" + matrix2);
        System.out.println("Matrix 1:\n" + value);
        System.out.println("Matrix 2:\n" + value2);
        System.out.println("Matrix 3 (copy of Matrix 1):\n" + matrix3);
        System.out.println("Matrix 4:\n" + matrix4);
        System.out.println("\nElement of matrix 2: "+ matrix2.getElement(1,0));
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
        // Розмірність матриці
        System.out.println("\nSize of matrix 2: "+ matrix2.getSize()[0] + "*" + matrix2.getSize()[1]);
        System.out.println("Size of matrix 4: "+ matrix4.getSize()[0] + "*" + matrix4.getSize()[1]); 
        // Хеш код
        System.out.println("Hash code of matrix 1: " + matrix1.hashCode());
        System.out.println("Hash code of matrix 2: " + matrix2.hashCode());
       System.out.println("Hash code of matrix 3: " + matrix3.hashCode());
       System.out.println("Hash code of matrix 4: " + matrix4.hashCode());
        // перевірка чи дві матриці рівні
        System.out.println("Matrix 1 equals Matrix 3: " + matrix1.equals(matrix3));
        System.out.println("Matrix 1 equals Matrix 4: " + matrix1.equals(matrix4));
        // Незмінна матриця
       ImmutableMatrix iMatrix = new ImmutableMatrix(matrix2);
        ImmutableMatrix iMatrix2 = new ImmutableMatrix(new double[][]{{5, 2, 3}, {4, 0, 6}, {7, 8, 0}});
        System.out.println("Immutable Matrix 1:\n" + iMatrix);
       System.out.println("Hash code of immutable matrix 2: " + iMatrix2.hashCode());
       System.out.println("Immutable matrix equals Matrix 2: " + iMatrix.equals(matrix2));
       System.out.println("Matrix 2 equals immutable matrix by value: " + matrix2.equals(iMatrix));
        ImmutableMatrix scalarResult = iMatrix.multiply(2.0);


        // Операції з матрицями
        Matrix sum = matrix1.add(matrix2);
        Matrix productScalar = matrix1.multiply(2.5);
         Matrix productMatrix = value.multiply(value2);
        System.out.println("Sum:\n" + sum);
        System.out.println("Scalar:\n" + productScalar);
         System.out.println("Product (Matrix):\n" + productMatrix);
        System.out.println("Immutable matrix (scalar):\n" + scalarResult);
        ImmutableMatrix sumResult = iMatrix.add(iMatrix2);
        System.out.println("Sum immutable:\n"+ sumResult);
        ImmutableMatrix productResult = iMatrix.multiply(iMatrix2);
        System.out.println("Multiply immutable matrix:\n" + productResult);

        // Транспонована матриця
        Matrix transposed = matrix1.transpose();
        System.out.println("Transposed Matrix 1:\n" + transposed);
        ImmutableMatrix transposedMatrix = iMatrix.transpose();
        System.out.println("Transposed immutable matrix 1:\n"+transposedMatrix);
        // Діагональна матриця
        Matrix diagonal = Matrix.diagonalMatrix(new double[]{12, 13, 44, -2, 14, -1});
        System.out.println("Diagonal Matrix:\n" + diagonal);
        // Одинична матриця
        Matrix identity = Matrix.identityMatrix(3);
        System.out.println("Identity Matrix:\n" + identity);
        // Матриця-рядок та матриця-стовпець з випадковими значеннями
        Matrix randomRow = Matrix.randomRowMatrix(4);
        ImmutableMatrix randomColumn = ImmutableMatrix.randomColumnMatrix(4);
        System.out.println("Random Row Matrix:\n" + randomRow);
        System.out.println("Random Column Immutable Matrix:\n" + randomColumn);
        //Верхня та нижня трикутні матриці
        int n = 3;
        double[][] matrixLower = new double[n][n];
        double[][] matrixUpper = new double[n][n];
        matrix2.performLUDecomposition(matrixLower, matrixUpper);
        System.out.println("Matrix 2 after elimination to upper triangular form:");
        printMatrix(matrixUpper);
        System.out.println("Matrix 2 after elimination to lower triangular form:");
        printMatrix(matrixLower);
    }
    // Метод для виведення матриці
    private static void printMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
