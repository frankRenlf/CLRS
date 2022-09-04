package leetcode.stage2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/4 12:26
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day12 {

    public int numSpecial(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] rowSum = new int[row], colSum = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                colSum[j] += mat[i][j];
                rowSum[i] += mat[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && colSum[j] == 1 && rowSum[i] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int jump(int[] nums) {
        int len = nums.length;
        int max = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (end == i) {
                count++;
                end = max;
            }
        }
        return count;
    }

}
