package leetcode.stage3;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/25 14:47
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day16 {

    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits_vio(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (int j = 0; j < num.length(); ++j) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                ++ans;
            }
        }
        return ans;
    }

    static int[] DIFFS = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    char[] s;
    int[][] dp;

    public int rotatedDigits(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][2];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, true);
    }

    int f(int i, int hasDiff, boolean isLimit) {
        if (i == s.length) {
            System.out.println(hasDiff);
            return hasDiff; // 只有包含 2/5/6/9 才算一个好数
        }
        if (!isLimit && dp[i][hasDiff] >= 0) return dp[i][hasDiff];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; ++d) // 枚举要填入的数字 d
            if (DIFFS[d] != -1) // d 不是 3/4/7
                res += f(i + 1, hasDiff | DIFFS[d], isLimit && d == up);
        if (!isLimit) dp[i][hasDiff] = res;
        return res;
    }

    static Day16 day16 = new Day16();

    public static void main(String[] args) {
        day16.rotatedDigits(12);
    }

}
