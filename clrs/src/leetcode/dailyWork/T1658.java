package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/7 12:07
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1658 {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int[] left = new int[len];
        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] += left[i - 1] + nums[i];
        }
        if (left[len - 1] < x) return -1;
        if (left[len - 1] == x) return len;
        int[] right = new int[len];
        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] += right[i + 1] + nums[i];
        }
        int ret = len;
        boolean k = false;
        for (int r = 1; r <= len; r++) {
            int l = -1;
            int sum = r==len?0:right[r];
            while (sum < x) {
                l++;
                sum = left[l] + (r == len ? 0 : right[r]);
            }
            if (sum == x) {
                k = true;
                ret = Math.min(l + 1 + len - r, ret);
            }
        }
        return k ? ret : -1;
    }
}
