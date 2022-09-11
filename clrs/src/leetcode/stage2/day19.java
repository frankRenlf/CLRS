package leetcode.stage2;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/11 10:02
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

//class Solution {
//    int[] nums;
//
//    public Solution(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int[] reset() {
//        return nums;
//    }
//
//    public int[] shuffle() {
//        int[] tmp = nums.clone();
//        int len = tmp.length;
//        Random rd = new Random();
//        for (int i = 0; i < nums.length; i++) {
//            swap(tmp, i, i + rd.nextInt(len - i));
//        }
//        return tmp;
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//}

public class day19 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[i] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int ret = 0;
        while (n != 0) {
            int d = n % 10;
            ret += d * d;
            n /= 10;
        }
        return ret;
    }

    static day19 d19 = new day19();

    public static void main(String[] args) {
        System.out.println(d19.isHappy(7));
    }

}
