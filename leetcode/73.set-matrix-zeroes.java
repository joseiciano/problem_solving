import java.util.Arrays;

/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    static int n;
    static int m;

    public void setZeroes(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        System.out.println("row = " + n + " col = " + m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("i = " + i + " j = " + j);
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++)
            if (row[i] == true)
                Arrays.fill(matrix[i], 0);

        for (int i = 0; i < m; i++)
            if (col[i] == true)
                for (int j = 0; j < n; j++)
                    matrix[j][i] = 0;
    }
}
// @lc code=end
