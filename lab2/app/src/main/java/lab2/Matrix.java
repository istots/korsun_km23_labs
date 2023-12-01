package lab2;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

      // Конструктори
      public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            this.data[i] = Arrays.copyOf(data[i], cols);
        }
    }


    public Matrix(Matrix matrix) {
        double[][] localData = matrix.getMatrix();
        this.rows = localData.length;
        this.cols = localData[0].length;
        this.data = localData;
    }

    // Створення пустої матриці
    public Matrix() {
        this.rows = 0;
        this.cols = 0;
        this.data = new double[rows][cols];
    }

    // Копіювання матриці
    public Matrix copy() {
        return new Matrix(this.data);
    }

    // Заповнення матриці значенням
    public void fill(double value) {
        for (int i = 0; i < rows; i++) {
            Arrays.fill(data[i], value);
        }
    }

    //Заповнення матриці значеннями за допомогою масиву value
    public void fill(double[][] value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = value[i][j];
            }
        }
    }
    // Метод toString для зручного виведення матриці
    public String toString() {
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixString.append(data[i][j]).append(" ");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }
    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }

    // Отримання елемента матриці
    public double getElement(int row, int col) {
        return data[row][col];
    }

    // Отримання рядка матриці
    public double[] getRow(int row) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row index");
        }

        return data[row].clone(); // Повертаємо клонований масив для інкапсуляції
    }

    // Отримання стовпця матриці
    public double[] getCol(int col) {
        double[] column = new double[rows];
        for (int i = 0; i < rows; i++) {
            column[i] = data[i][col];
        }
        return column;
    }

    // Розмірність матриці
    public int[] getSize() {
        return new int[] { rows, cols };
    }

    // Хеш код
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += Arrays.hashCode(data[i]);
        }
        return result;
    }

     // Метод для порівняння двох матриць на рівність
     public boolean equals(Matrix otherMatrix) {
        if (this == otherMatrix)
            return true;
        if (otherMatrix == null || getClass() != otherMatrix.getClass())
            return false;

        int[] size1 = this.getSize();
        int[] size2 = otherMatrix.getSize();

        // Перевірка розмірностей матриць
        if (size1[0] != size2[0] || size1[1] != size2[1])
            return false;

        // Перевірка елементів матриць
        for (int i = 0; i < size1[0]; i++) {
            for (int j = 0; j < size1[1]; j++) {
                if (this.getElement(i, j) != otherMatrix.getElement(i, j))
                    return false;
            }
        }

        return true;
    }

    public boolean equals(ImmutableMatrix otherMatrix) {
        // if (this == otherMatrix) return true;
        // if (otherMatrix == null || getClass() != otherMatrix.getClass()) return
        // false;

        int[] size1 = this.getSize();
        int[] size2 = otherMatrix.getSize();

        // Перевірка розмірностей матриць
        if (size1[0] != size2[0] || size1[1] != size2[1])
            return false;

        // Перевірка елементів матриць
        for (int i = 0; i < size1[0]; i++) {
            for (int j = 0; j < size1[1]; j++) {
                if (this.getElement(i, j) != otherMatrix.getElement(i, j))
                    return false;
            }
        }

        return true;
    }

    // Операції додавання матриць та множення на скаляр
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions must be the same");
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(double scalar) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    // Операція множення матриць
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException(
                    "Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }

        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0.0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    // Транспонована матриця
    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result.data[i][j] = this.data[j][i];
            }
        }
        return result;
    }

    // Діагональна матриця
    public static Matrix diagonalMatrix(double[] vector) {
        int n = vector.length;
        Matrix result = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            result.data[i][i] = vector[i];
        }
        return result;
    }

     // Одинична матриця
     public static Matrix identityMatrix(int size) {
        Matrix result = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            result.data[i][i] = 1.0;
        }
        return result;
    }

     // Матриця-рядок з випадковими значеннями
    public static Matrix randomRowMatrix(int size) {
        Random random = new Random();
        double[][] data = new double[1][size];
        for (int i = 0; i < size; i++) {
            data[0][i] = random.nextDouble();
        }
        return new Matrix(data);
    }

    // Матриця-стовпець з випадковими значеннями
    public static Matrix randomColumnMatrix(int size) {
        Random random = new Random();
        double[][] data = new double[size][1];
        for (int i = 0; i < size; i++) {
            data[i][0] = random.nextDouble();
        }
        return new Matrix(data);
    }

    public double[][] getMatrix() {
        return this.data;
    }
}