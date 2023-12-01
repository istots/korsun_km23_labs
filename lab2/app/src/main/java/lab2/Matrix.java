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

   // public double[][] getMatrix() {
       // return this.data;
    //}
}