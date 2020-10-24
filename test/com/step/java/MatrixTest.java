package com.step.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldCreateMatrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    assertNotNull(mt);
  }

  @Test
  public void shouldReturnNullForDifferentDimensions() {
    int[][] values = { { 1, 2 }, { 3, 4, 5 } };
    Matrix mt = Matrix.createMatrix(values);
    assertEquals(null, mt);
  }

  @Test
  public void shouldAddMatrix() {
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
  public void addShouldReturnNullForDifferentRowDimension() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.add(anotherMt);
    assertEquals(null, actual);
  }

  @Test
  public void addShouldReturnNullForDifferentColumnDimension() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.add(anotherMt);
    assertEquals(null, actual);
  }

  @Test
  public void shouldSubtractWithGivenMatrix() {
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
  public void subShouldReturnNullForDifferentRowDimension() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.sub(anotherMt);
    assertEquals(null, actual);
  }

  @Test
  public void subShouldReturnNullForDifferentColumnDimension() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.sub(anotherMt);
    assertEquals(null, actual);
  }

  @Test
  public void shouldMultiplyWithInt() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    Matrix actual = mt.multiply(2);
    int[][] expectedValues = { { 2, 4 }, { 6, 8 } };
    Matrix expected = Matrix.createMatrix(expectedValues);
    assertEquals(expected, actual);
  }

  @Test
  public void shouldMultiplyWithGivenMatrix() {
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
  public void multiplyShouldReturnNUllForGivenDifferentRowSizeMatrix() {
    int[][] values = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix mt = Matrix.createMatrix(values);
    int[][] anotherValues = { { 1, 2 }, { 3, 4 } };
    Matrix anotherMt = Matrix.createMatrix(anotherValues);
    Matrix actual = mt.multiply(anotherMt);
    assertEquals(null, actual);
  }

  @Test
  public void getDeterminant_shouldReturnDeterminantOf_2x2_Matrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int actual = mt.getDeterminant();
    assertEquals(-2, actual);
  }

  @Test
  public void getDeterminant_shouldReturnDeterminantOf_3x3_Matrix() {
    int[][] values = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix anotherMt = Matrix.createMatrix(values);
    int actual = anotherMt.getDeterminant();
    assertEquals(0, actual);
  }

  public void getDeterminantShouldReturnNullForNotSquareMatrix() {
    int[][] values = { { 1, 2 }, { 3, 4 } };
    Matrix mt = Matrix.createMatrix(values);
    int actual = mt.getDeterminant();
    assertEquals(null, actual);
  }
}
