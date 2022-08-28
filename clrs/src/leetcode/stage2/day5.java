package leetcode.stage2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/28 10:40
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

class Solution1 {
    public int preimageSizeFZF(int k) {
        if (k <= 1) return 5;
        return f(k) - f(k - 1);
    }

    int f(int x) {
        long l = 0, r = (long) 1e10;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (getCnt(mid) <= x) l = mid;
            else r = mid - 1;
        }
        System.out.println(r);
        return (int) r;
    }

    long getCnt(long x) {
        long ans = 0;
        while (x != 0) {
            x /= 5;
            ans += x;
        }
        return ans;
    }
}

public class day5 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands_dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void numIslands_dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        numIslands_dfs(grid, i - 1, j);
        numIslands_dfs(grid, i, j + 1);
        numIslands_dfs(grid, i, j - 1);
        numIslands_dfs(grid, i + 1, j);
    }

    public int trailingZeroes(int n) {
        int ret = 0;
        while (n != 0) {
            n /= 5;
            ret += n;
        }
        return ret;
    }

    public int preimageSizeFZF(int k) {
        long l = k - 1, r = k * 10L + 1;
        while (l + 1 < r) {
            long m = l + r >> 1, t = f(m);
            if (t == k) return 5;
            else if (t < k) l = m;
            else r = m;
        }
        return 0;
    }

    long f(long n) {
        if (n == 0) return 0;
        return n / 5 + f(n / 5);
    }

    static day5 d5 = new day5();
    static Solution1 sol1 = new Solution1();

    public static void main(String[] args) {
//        d5.trailingZeroes(1);
        System.out.println(sol1.preimageSizeFZF(12));
    }

}
