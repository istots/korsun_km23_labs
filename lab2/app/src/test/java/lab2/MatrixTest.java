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
}
