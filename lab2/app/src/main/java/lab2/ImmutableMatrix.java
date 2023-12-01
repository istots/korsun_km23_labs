package lab2;

public final class ImmutableMatrix {
    private final Matrix matrix;

    // Конструктор для імутабельного класу
    public ImmutableMatrix(Matrix matrix) {
        this.matrix = new Matrix(matrix);
    }
    public ImmutableMatrix(double[][] ds) {
        this.matrix = new Matrix(ds);
    }
    

    // Жодних публічних методів для модифікації об'єкта
    // Лише методи для читання даних, в нашому випадку отримання розмірності/елементів/рядків/стовпців

    // Метод для отримання розмірності матриці
    public int[] getSize() {
        return matrix.getSize();
    }

    // Метод для отримання значення заданого елемента
    public double getElement(int row, int col) {
        return matrix.getElement(row, col);
    }

    // Метод для отримання заданого рядка
    public double[] getRow(int rowIndex) {
        return matrix.getRow(rowIndex);
    }

    // Метод для отримання заданого стовпчика
    public double[] getColumn(int colIndex) {
        return matrix.getCol(colIndex);
    }


    // Перевизначення методу hashCode для імутабельної матриці
    @Override
    public int hashCode() {
        return matrix.hashCode();
    }

    // Метод toString для зручного виведення матриці
    public String toString() {
        int[] size = getSize();
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                matrixString.append(getElement(i,j)).append(" ");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }

    // Множення незмінної матриці на скаляр
    public ImmutableMatrix multiply(double scalar) {
        Matrix result = matrix.multiply(scalar);
        return new ImmutableMatrix(result);
    }

    // Додавання двох матриць
    public ImmutableMatrix add(ImmutableMatrix other) {
        Matrix result = matrix.add(other.matrix);
        return new ImmutableMatrix(result);
        }

    // Множення матриці на матрицю
    public ImmutableMatrix multiply(ImmutableMatrix other) {
        Matrix result = matrix.multiply(other.matrix);
        return new ImmutableMatrix(result);
    }
    public ImmutableMatrix transpose() {
        int rows = getSize()[0];
        int cols = getSize()[1];

        double[][] transposedData = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedData[j][i] = matrix.getElement(i, j);
            }
        }

        return new ImmutableMatrix(transposedData);
    }

    // Конструктор для діагональної матриці
    public static ImmutableMatrix diagonalMatrix(double[] diagonalValues) {
        int size = diagonalValues.length;
        double[][] matrixData = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixData[i][j] = (i == j) ? diagonalValues[i] : 0.0;
            }
        }

        return new ImmutableMatrix(matrixData);
    }

    public static ImmutableMatrix identityMatrix(int n) {
        double[][] identityData = new double[n][n];
        for (int i = 0; i < n; i++) {
            identityData[i][i] = 1.0;
        }
        return new ImmutableMatrix(identityData);
    }

}

