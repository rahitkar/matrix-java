package com.step.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void createMatrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    assertNotNull(mt);
  }

  @Test
  public void createMatrixWithDifferentSizeColumns() {
    int[][] values = { { 1, 2 }, { 3, 4, 5 } };
    Matrix mt = Matrix.createMatrix(values);
    assertNull(mt);
  }

  @Test
  public void addMatrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);

    Matrix actual = mt.add(anotherMt);
    int[][] expectedValues = { { 2, 4 }, { 6, 8 } };
    Matrix expected = Matrix.createMatrix(expectedValues);
    assertEquals(expected, actual);
  }

  @Test
  public void addWithDifferentRowSize() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.add(anotherMt);
    assertNull(actual);
  }

  @Test
  public void addWithDifferentColumnSize() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.add(anotherMt);
    assertNull(actual);
  }

  @Test
  public void subMatrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.sub(anotherMt);
    int[][] expectedValues = { { 0, 0 }, { 0, 0 } };
    Matrix expected = Matrix.createMatrix(expectedValues);
    assertEquals(expected, actual);
  }

  @Test
  public void subWithDifferentRowSize() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.sub(anotherMt);
    assertNull(actual);
  }

  @Test
  public void subWithDifferentColumnSize() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.sub(anotherMt);
    assertNull(actual);
  }

  @Test
  public void multiplyWithInt() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    Matrix actual = mt.multiply(2);
    int[][] expectedValues = { { 2, 4 }, { 6, 8 } };
    Matrix expected = Matrix.createMatrix(expectedValues);
    assertEquals(expected, actual);
  }

  @Test
  public void multiplyWithMatrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.multiply(anotherMt);
    int[][] expectedValues = { { 7, 10 }, { 15, 22 } };
    Matrix expected = Matrix.createMatrix(expectedValues);
    assertEquals(expected, actual);
  }

  @Test
  public void multiplyWithDifferentRowSizeMatrix() {
    int[][] values = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.multiply(anotherMt);
    assertNull(actual);
  }

  @Test
  public void getDeterminant2X2Matrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int actual = mt.getDeterminant();
    assertEquals(-2, actual);
  }

  @Test
  public void getDeterminant3X3Matrix() {
    int[][] values = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix anotherMt = Matrix.createMatrix(values);
    int actual = anotherMt.getDeterminant();
    assertEquals(0, actual);
  }

  public void getDeterminantOfNotSquareMatrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int actual = mt.getDeterminant();
    assertNull(actual);
  }
}
