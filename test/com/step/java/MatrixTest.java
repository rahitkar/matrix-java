package com.step.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void isAdded() {
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
  public void isSubtracted() {
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
  public void isMultipliedWithInt() {
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
  public void isMultipliedWithMatrix() {
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
}
