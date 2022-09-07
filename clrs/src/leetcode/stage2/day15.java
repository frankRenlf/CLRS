package leetcode.stage2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/7 9:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day15 {

    public String reorderSpaces(String s) {
        int n = s.length(), cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ' && ++i >= 0 && ++cnt >= 0) continue;
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            list.add(s.substring(i, j));
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        int m = list.size(), t = cnt / Math.max(m - 1, 1);
        StringBuilder k = new StringBuilder();
        while (t-- > 0) k.append(" ");
        for (int i = 0; i < m; i++) {
            sb.append(list.get(i));
            if (i != m - 1) sb.append(k);
        }
        while (sb.length() != n) sb.append(" ");
        return sb.toString();
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLen) ret += count[i];
        }
        return ret;
    }


    static day15 d15 = new day15();

    public static void main(String[] args) {
        System.out.println(d15.reorderSpaces("  this   is  a sentence "));
    }


}
