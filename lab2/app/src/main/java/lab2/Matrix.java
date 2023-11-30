package lab2;

import java.util.Arrays;

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
}