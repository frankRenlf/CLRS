package leetcode.dailyWork;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/21 9:58
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1326 {
    public int minTaps(int n, int[] ranges) {
        int[][] gaps = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            gaps[i] = new int[]{start, end};
        }
        Arrays.sort(gaps, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int[] gap :
                gaps) {
            int start = gap[0];
            int end = gap[1];
            if (dp[start] == Integer.MAX_VALUE) {
                return -1;
            }
            for (int i = start; i <= end; i++) {
                dp[i] = Math.min(dp[i], dp[start] + 1);
            }
        }
        return dp[n];
    }

    static T1326 t1326 = new T1326();

    public static void main(String[] args) {
        System.out.println(t1326.minTaps(8, new int[]{
                4, 0, 0, 0, 0, 0, 0, 0, 4}));
    }
}
