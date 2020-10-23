// add : For addition of two matrices
// subtract : subtraction of two matrices
// multiply : multiplication of two matrices
// determinant : get a determinant of the matrix

package com.step.java;

public class Matrix {
  private final int rows;
  private final int columns;
  private int[][] values;

  public Matrix(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.values = new int[rows][columns];
  }

  public static Matrix createMatrix(int[][] rows) {
    Matrix newMatrix = new Matrix(rows.length, rows[0].length);

    for (int rowNo = 0; rowNo < newMatrix.rows; rowNo++) {
      if (rows[rowNo].length != newMatrix.columns) {
        return null;
      }
      for (int colNo = 0; colNo < newMatrix.columns; colNo++) {
        newMatrix.values[rowNo][colNo] = rows[rowNo][colNo];
      }
    }
    return newMatrix;
  }

  private boolean isValid(Matrix matrix) {
    return (this.rows != matrix.rows || this.columns != matrix.columns);
  }

  public Matrix add(Matrix anotherMatrix) {
    if (isValid(anotherMatrix)) return null;

    int[][] newMatrixValues = new int[this.rows][this.columns];

    for (int rowNo = 0; rowNo < this.rows; rowNo++) {
      for (int colNo = 0; colNo < this.columns; colNo++) {
        newMatrixValues[rowNo][colNo] =
          this.values[rowNo][colNo] + anotherMatrix.values[rowNo][colNo];
      }
    }
    return createMatrix(newMatrixValues);
  }

  public Matrix sub(Matrix anotherMatrix) {
    if (isValid(anotherMatrix)) return null;

    int[][] newMatrixValues = new int[this.rows][this.columns];

    for (int rowNo = 0; rowNo < this.rows; rowNo++) {
      for (int colNo = 0; colNo < this.columns; colNo++) {
        newMatrixValues[rowNo][colNo] =
          this.values[rowNo][colNo] - anotherMatrix.values[rowNo][colNo];
      }
    }
    return createMatrix(newMatrixValues);
  }

  public Matrix multiply(int multiplier) {
    int[][] newMatrixValues = new int[this.rows][this.columns];

    for (int rowNo = 0; rowNo < this.rows; rowNo++) {
      for (int colNo = 0; colNo < this.columns; colNo++) {
        newMatrixValues[rowNo][colNo] = this.values[rowNo][colNo] * multiplier;
      }
    }
    return createMatrix(newMatrixValues);
  }

  public Matrix multiply(Matrix anotherMatrix) {
    if (this.columns != anotherMatrix.rows) return null;

    int[][] newMatrixValues = new int[this.rows][this.columns];

    for (int rowNo = 0; rowNo < this.rows; rowNo++) {
      for (int colNo = 0; colNo < this.columns; colNo++) {
        newMatrixValues[rowNo][colNo] = 0;
        for (int i = 0; i < this.columns; i++) {
          newMatrixValues[rowNo][colNo] +=
            this.values[rowNo][i] * anotherMatrix.values[i][colNo];
        }
      }
    }
    return createMatrix(newMatrixValues);
  }

  private Matrix getSubMatrix(int rIdx, int cIdx) {
    int[][] subMatrixValues = new int[this.rows - 1][this.columns - 1];
    for (int rowNo = 0, sRow = 0; rowNo < this.rows; rowNo++) {
      if (rowNo == rIdx) {
        continue;
      }
      for (int colNo = 0, sCol = 0; colNo < this.columns; colNo++) {
        if (colNo == cIdx) {
          continue;
        }
        subMatrixValues[sRow][sCol] = this.values[rowNo][colNo];
        sCol++;
      }
      sRow++;
    }
    return createMatrix(subMatrixValues);
  }

  public Integer getDeterminant() {
    if (this.rows != this.columns) return null;
    if (this.rows == 2) {
      return (
        this.values[0][0] *
        this.values[1][1] -
        this.values[0][1] *
        this.values[1][0]
      );
    }
    Integer determinant = new Integer(0);
    for (int colNo = 0; colNo < this.columns; colNo++) {
      int sign = colNo % 2 != 0 ? -1 : 1;
      int multiplier = sign * this.values[0][colNo];
      int subMatrixDeterminant = this.getSubMatrix(0, colNo).getDeterminant();
      determinant += multiplier * subMatrixDeterminant;
    }
    return determinant;
  }

  @Override
  public String toString() {
    String matrix = "";
    for (int row[] : this.values) {
      for (int cell : row) {
        matrix += cell + " ";
      }
      matrix += "\n";
    }
    return matrix;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (!(object instanceof Matrix)) return false;
    Matrix matrix = (Matrix) object;
    if (isValid(matrix)) return false;

    for (int rowNo = 0; rowNo < matrix.rows; rowNo++) {
      for (int colNo = 0; colNo < matrix.columns; colNo++) {
        if (this.values[rowNo][colNo] != matrix.values[rowNo][colNo]) {
          return false;
        }
      }
    }
    return true;
  }
}
