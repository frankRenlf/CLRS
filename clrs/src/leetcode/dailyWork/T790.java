package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/12 11:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T790 {
    static final int MOD = 1000000007;

    public int numTilings(int n) {
        if (n <= 3) {
            return n == 3 ? 5 : n;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int x = 4; x <= n; x++) {
            dp[x] = (2 * dp[x - 1] + dp[x - 3]) % MOD;
        }
        return (int) dp[n];
    }

}
