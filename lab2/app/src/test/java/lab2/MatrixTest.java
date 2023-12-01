package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

@Test
    void testEmptyMatrixConstructor() {
        Matrix emptyMatrix = new Matrix();
        assertEquals(0, emptyMatrix.getRows());
        assertEquals(0, emptyMatrix.getCols());
    }

    @Test
    void testMatrixConstructorWithData() {
        double[][] testData = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix matrix = new Matrix(testData);
        assertEquals(3, matrix.getRows());
        assertEquals(3, matrix.getCols());
        assertEquals("1.0 2.0 3.0 \n4.0 5.0 6.0 \n7.0 8.0 9.0 \n", matrix.toString());
    }

    @Test
    void testCopyMethod() {
        double[][] testData = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix originalMatrix = new Matrix(testData);
        Matrix copiedMatrix = originalMatrix.copy();
        assertEquals(originalMatrix.toString(), copiedMatrix.toString());
    }

    @Test
    void testFillMethod() {
        Matrix matrix = new Matrix(2, 2);
        matrix.fill(5.0);
        assertEquals("5.0 5.0 \n5.0 5.0 \n", matrix.toString());
    }

    @Test
    void testFillMethodWithArray() {
        Matrix matrix = new Matrix(2, 2);
        double[][] testData = {{1.0, 2.0}, {3.0, 4.0}};
        matrix.fill(testData);
        assertEquals("1.0 2.0 \n3.0 4.0 \n", matrix.toString());
    }

    @Test
    void testGetElement() {
        double[][] testData = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix matrix = new Matrix(testData);

        assertEquals(5.0, matrix.getElement(1, 1));
        assertEquals(7.0, matrix.getElement(2, 0));
    }

    @Test
    void testGetRow() {
        double[][] testData = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix matrix = new Matrix(testData);

        assertArrayEquals(new double[]{4.0, 5.0, 6.0}, matrix.getRow(1));
        assertThrows(IllegalArgumentException.class, () -> matrix.getRow(5));
    }

    @Test
    void testGetCol() {
        double[][] testData = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix matrix = new Matrix(testData);

        assertArrayEquals(new double[]{2.0, 5.0, 8.0}, matrix.getCol(1));
        assertThrows(IllegalArgumentException.class, () -> matrix.getCol(5));
    }

    @Test
    void testHashCode() {
        double[][] data1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] data2 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] data3 = {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix matrix3 = new Matrix(data3);

        assertEquals(matrix1.hashCode(), matrix2.hashCode());
        assertNotEquals(matrix1.hashCode(), matrix3.hashCode());
    }

    @Test
    void testEquals() {
        double[][] data1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] data2 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] data3 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix matrix3 = new Matrix(data3);

        // Очікуємо, що матриці matrix1 і matrix2 не рівні, а matrix1 і matrix3 - рівні
        assertTrue(matrix1.equals(matrix2));
        assertFalse(matrix1.equals(matrix3));
    }

    @Test
    void testMatrixAddition() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        Matrix expected = new Matrix(new double[][]{{6, 8}, {10, 12}});

        Matrix result = matrix1.add(matrix2);

        assertArrayEquals(expected.getMatrix(), result.getMatrix());
    }

    @Test
    void testMatrixScalarMultiplication() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        double scalar = 2;
        Matrix expected = new Matrix(new double[][]{{2, 4}, {6, 8}});

        Matrix result = matrix.multiply(scalar);

        assertArrayEquals(expected.getMatrix(), result.getMatrix());
    }

    @Test
    void testMatrixMultiplication() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        Matrix expected = new Matrix(new double[][]{{19, 22}, {43, 50}});

        Matrix result = matrix1.multiply(matrix2);

        assertArrayEquals(expected.getMatrix(), result.getMatrix());
    }

    @Test
    void transpose() {
        Matrix originalMatrix = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix transposedMatrix = originalMatrix.transpose();
        Matrix expectedMatrix = new Matrix(new double[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});
        assertEquals(expectedMatrix, transposedMatrix);
    }

    @Test
    void diagonalMatrix() {
        // Тест для створення діагональної матриці з вектора {1, 2, 3}
        double[] vector1 = {1, 2, 3};
        Matrix result1 = Matrix.diagonalMatrix(vector1);

        // Перевірка розмірності матриці
        int[] size1 = result1.getSize();
        assertEquals(3, size1[0]);
        assertEquals(3, size1[1]);

        // Перевірка значень на діагоналі
        for (int i = 0; i < 3; i++) {
            assertEquals(vector1[i], result1.getElement(i, i));
        }

        // Тест для створення діагональної матриці з вектора {5, 5, 5}
        double[] vector2 = {5, 5, 5};
        Matrix result2 = Matrix.diagonalMatrix(vector2);

        // Перевірка розмірності матриці
        int[] size2 = result2.getSize();
        assertEquals(3, size2[0]);
        assertEquals(3, size2[1]);

        // Перевірка значень на діагоналі
        for (int i = 0; i < 3; i++) {
            assertEquals(vector2[i], result2.getElement(i, i));
        }
    }

}
