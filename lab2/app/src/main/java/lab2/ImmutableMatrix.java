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

}

