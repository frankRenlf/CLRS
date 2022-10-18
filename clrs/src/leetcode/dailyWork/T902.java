package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/18 10:50
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T902 {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int len = digits.length;
        String s = Integer.toString(n);
        int k = s.length();
        int[][] dp = new int[k + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i <= k; i++) {
            for (String digit : digits) {
                // add each element to [i][0] which is smaller than cur
                if (digit.charAt(0) < s.charAt(i - 1)) {
                    dp[i][0] += dp[i - 1][1];
                    // add each element to [i][1] which is equal to cur
                } else if (digit.charAt(0) == s.charAt(i - 1)) {
                    dp[i][1] = dp[i - 1][1];
                } else {
                    break;
                }
            }
            //
            if (i > 1) {
                dp[i][0] += len + dp[i - 1][0] * len;
            }
        }
        return dp[k][0] + dp[k][1];
    }

}
