package leetcode.dailyWork;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/22 20:41
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
class Solution1 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    public int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

public class T1235 {
}
