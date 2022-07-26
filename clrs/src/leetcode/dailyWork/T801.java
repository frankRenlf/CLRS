package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/10 11:01
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T801 {

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) dp[i][0] = dp[i][1] = Integer.MAX_VALUE;
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public int minSwap2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n0 = 0;
        int n1 = 1;
        for (int i = 1; i < n; i++) {
            int cur0 = n0;
            int cur1 = n1;
            n0 = n1 = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                n0 = cur0;
                n1 = cur1 + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                n0 = Math.min(n0, cur1);
                n1 = Math.min(n1, cur0 + 1);
            }
        }
        return Math.min(n0, n1);
    }

}
