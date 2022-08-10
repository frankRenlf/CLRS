package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/10 15:17
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day2 {

    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] ret = new int[right + 1];
        int index = right;
        while (left <= right) {
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];
            if (leftVal > rightVal) {
                ret[index] = leftVal;
                left++;
            } else {
                ret[index] = rightVal;
                right--;
            }
            index--;
        }
        return ret;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int step = k % len;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[(i + step) % len] = nums[i];
        }
        System.arraycopy(tmp, 0, nums, 0, len);
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int step = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, step - 1);
        reverse(nums, step, len - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

}
