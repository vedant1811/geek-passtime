// https://www.geeksforgeeks.org/a-boolean-matrix-question/

import java.util.*;

class Main {
  public static void setOnes(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        if (a[i][j] == 1) {
          for (int k = 0; k < a.length; k++) {
            a[k][j] = 2;
          }
          for (int k = 0; k < a[0].length; k++) {
            a[i][k] = 2;
          }
          break;
        }
      }
    }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        if (a[i][j] == 2) {
          a[i][j] = 1;
        }
        System.out.println(i + " / " + j + " " + a[i][j]);
      }
      // System.out.println(i + "---111 " + " ");
    }
  }

  public static void main(String[] args) {

        int mat[ ][ ] = { {1, 0, 0, 1},
                          {0, 0, 1, 0},
                          {0, 0, 0, 0},};

                System.out.println("Matrix Intially");

                printMatrix(mat, 3, 4);

                setOnes(mat);
                System.out.println("Matrix after modification n");
                printMatrix(mat, 3, 4);
  }


    /* A utility function to print a 2D matrix */
    public static void printMatrix(int mat[ ][ ], int R, int C)
    {
        int i, j;
        for (i = 0; i < R; i++)
        {
            for (j = 0; j < C; j++)
            {
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
