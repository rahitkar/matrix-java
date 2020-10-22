// add : For addition of two matrices
// subtract : subtraction of two matrices
// multiply : multiplication of two matrices
// determinant : get a determinant of the matrix

package com.step.java;

public class Matrix {
  private final int rows;
  private final int columns;
  private int[][] matrix;

  public Matrix(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.matrix = new int[rows][columns];
  }

  public static Matrix createMatrix(int[][] rows) {
    Matrix newMatrix = new Matrix(rows.length, rows[0].length);

    for (int rowNo = 0; rowNo < newMatrix.rows; rowNo++) {
      if (rows[rowNo].length != newMatrix.columns) {
        return null;
      }
      for (int cell = 0; cell < newMatrix.columns; cell++) {
        newMatrix.matrix[rowNo][cell] = rows[rowNo][cell];
      }
    }
    return newMatrix;
  }

  public Matrix add(Matrix anotherMatrix) {
    Matrix newMatrix = new Matrix(this.rows, this.columns);

    if (
      this.rows != anotherMatrix.rows || this.columns != anotherMatrix.columns
    ) return null;

    for (int rowNo = 0; rowNo < this.rows; rowNo++) {
      for (int colNo = 0; colNo < this.columns; colNo++) {
        newMatrix.matrix[rowNo][colNo] =
          this.matrix[rowNo][colNo] + anotherMatrix.matrix[rowNo][colNo];
      }
    }
    return newMatrix;
  }

  public Matrix sub(Matrix anotherMatrix) {
    Matrix newMatrix = new Matrix(this.rows, this.columns);

    if (
      this.rows != anotherMatrix.rows || this.columns != anotherMatrix.columns
    ) return null;

    for (int rowNo = 0; rowNo < this.rows; rowNo++) {
      for (int colNo = 0; colNo < this.columns; colNo++) {
        newMatrix.matrix[rowNo][colNo] =
          this.matrix[rowNo][colNo] - anotherMatrix.matrix[rowNo][colNo];
      }
    }
    return newMatrix;
  }

  public Matrix multiply(int multiplier) {
    Matrix newMatrix = new Matrix(this.rows, this.columns);

    for (int rowNo = 0; rowNo < this.rows; rowNo++) {
      for (int colNo = 0; colNo < this.columns; colNo++) {
        newMatrix.matrix[rowNo][colNo] =
          this.matrix[rowNo][colNo] * multiplier;
      }
    }
    return newMatrix;
  }

  public Matrix multiply(Matrix anotherMatrix) {
    Matrix newMatrix = new Matrix(this.rows, anotherMatrix.columns);

    if (this.columns != anotherMatrix.rows) return null;

    for (int rowNo = 0; rowNo < newMatrix.rows; rowNo++) {
      for (int colNo = 0; colNo < newMatrix.columns; colNo++) {
        newMatrix.matrix[rowNo][colNo] = 0;
        for (int i = 0; i < this.columns; i++) {
          newMatrix.matrix[rowNo][colNo] +=
            this.matrix[rowNo][i] * anotherMatrix.matrix[i][colNo];
        }
      }
    }
    return newMatrix;
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
        subMatrixValues[sRow][sCol] = this.matrix[rowNo][colNo];
        sCol++;
      }
      sRow++;
    }
    Matrix subMatrix = Matrix.createMatrix(subMatrixValues);
    return subMatrix;
  }

  public Integer getDeterminant() {
    if (this.rows != this.columns) return null;
    if (this.rows == 2) {
      return (
        this.matrix[0][0] *
        this.matrix[1][1] -
        this.matrix[0][1] *
        this.matrix[1][0]
      );
    }
    Integer determinant = new Integer(0);
    for (int colNo = 0; colNo < this.columns; colNo++) {
      int sign = colNo % 2 != 0 ? -1 : 1;
      determinant +=
        sign *
        this.matrix[0][colNo] *
        this.getSubMatrix(0, colNo).getDeterminant();
    }
    return determinant;
  }

  @Override
  public String toString() {
    String matrix = "";
    for (int row[] : this.matrix) {
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
    if (
      matrix.columns != this.columns || matrix.rows != this.rows
    ) return false;

    for (int rowNo = 0; rowNo < matrix.rows; rowNo++) {
      for (int colNo = 0; colNo < matrix.columns; colNo++) {
        if (this.matrix[rowNo][colNo] != matrix.matrix[rowNo][colNo]) {
          return false;
        }
      }
    }
    return true;
  }
}
