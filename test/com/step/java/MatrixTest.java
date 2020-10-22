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

    assertNotNull("should return a instance of Matrix class", mt);
  }

  @Test
  public void createMatrixWithDifferentSizeColumns() {
    int[][] values = { { 1, 2 }, { 3, 4, 5 } };
    Matrix mt = Matrix.createMatrix(values);

    assertNull(
      "should return null for given list with different size of columns",
      mt
    );
  }

  @Test
  public void add() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);

    Matrix actual = mt.add(anotherMt);
    int[][] expectedValues = { { 2, 4 }, { 6, 8 } };
    Matrix expected = Matrix.createMatrix(expectedValues);
    assertEquals(
      "should return a new matrix with the new values after addition with given matrix",
      expected,
      actual
    );
  }

  @Test
  public void addWithDifferentRowSize() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);

    Matrix actual = mt.add(anotherMt);

    assertNull(
      "should return null for given different row sized matrix",
      actual
    );
  }

  @Test
  public void addWithDifferentColumnSize() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);

    Matrix actual = mt.add(anotherMt);

    assertNull(
      "should return null for given different column sized matrix",
      actual
    );
  }

  @Test
  public void sub() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);

    Matrix actual = mt.sub(anotherMt);
    int[][] expectedValues = { { 0, 0 }, { 0, 0 } };
    Matrix expected = Matrix.createMatrix(expectedValues);
    assertEquals(
      "should return a new matrix with the new values after subtraction with given matrix",
      expected,
      actual
    );
  }

  @Test
  public void subWithDifferentRowSize() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);

    Matrix actual = mt.sub(anotherMt);

    assertNull(
      "should return null for given different row sized matrix",
      actual
    );
  }

  @Test
  public void subWithDifferentColumnSize() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);

    Matrix actual = mt.sub(anotherMt);

    assertNull(
      "should return null for given different column sized matrix",
      actual
    );
  }

  @Test
  public void multiplyWithInt() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);

    Matrix actual = mt.multiply(2);

    int[][] expectedValues = { { 2, 4 }, { 6, 8 } };
    Matrix expected = Matrix.createMatrix(expectedValues);
    assertEquals(
      "should return a new matrix with the new values after multiplying with with given Integer",
      expected,
      actual
    );
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
    assertEquals(
      "should return a new matrix with the new values after multiplying with given matrix",
      expected,
      actual
    );
  }

  @Test
  public void multiplyWithDifferentRowSizeMatrix() {
    int[][] values = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);

    Matrix actual = mt.multiply(anotherMt);

    assertNull(
      "should return null for given different row sized matrix",
      actual
    );
  }

  @Test
  public void getDeterminant() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);

    int actual = mt.getDeterminant();
    assertEquals("should return the determinant value of given 2X2 matrix", -2, actual);

    int[][] anotherValues = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    actual = anotherMt.getDeterminant();
    assertEquals("should return the determinant value of given 3X3 matrix",0, actual);
  }

  public void getDeterminantOfNotSquareMatrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);

    int actual = mt.getDeterminant();
    assertNull("should return null for given not square matrix", actual);
  }
}
