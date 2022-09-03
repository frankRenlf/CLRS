package leetcode.stage2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/3 10:40
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day11 {

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0) return 0;
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) return true;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = dp[0] > 0 ? Math.max(dp[0], nums[1] + 1) : 0;
        for (int i = 2; i < len; i++) {
            if (dp[i - 1] < i) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
        }
        return true;
    }

    public int rob(int[] nums) {

    }

}
