package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/10 15:17
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day2 {

    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] ret = new int[right + 1];
        int index = right;
        while (left <= right) {
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];
            if (leftVal > rightVal) {
                ret[index] = leftVal;
                left++;
            } else {
                ret[index] = rightVal;
                right--;
            }
            index--;
        }
        return ret;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int step = k % len;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[(i + step) % len] = nums[i];
        }
        System.arraycopy(tmp, 0, nums, 0, len);
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int step = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, step - 1);
        reverse(nums, step, len - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ret[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = mat[i][j] == 0 ? 0 : ret[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    ret[i][j] = Math.min(ret[i - 1][j] + 1, ret[i][j]);
                }
                if (j > 0) {
                    ret[i][j] = Math.min(ret[i][j], ret[i][j - 1] + 1);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    ret[i][j] = Math.min(ret[i + 1][j] + 1, ret[i][j]);
                }
                if (j < n - 1) {
                    ret[i][j] = Math.min(ret[i][j], ret[i][j + 1] + 1);
                }
            }
        }
        return ret;
    }


    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int time = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    orangesRotting_dfs(grid, i, j, 2);
                }
            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
                time = Math.max(time, ints[j]);
            }
        }
        return time == 0 ? 0 : time - 2;
    }

    private void orangesRotting_dfs(int[][] grid, int i, int j, int time) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || (grid[i][j] != 1 && grid[i][j] < time)) {
            return;
        }
        grid[i][j] = time;
        orangesRotting_dfs(grid, i - 1, j, time + 1);
        orangesRotting_dfs(grid, i + 1, j, time + 1);
        orangesRotting_dfs(grid, i, j - 1, time + 1);
        orangesRotting_dfs(grid, i, j + 1, time + 1);
    }


}
