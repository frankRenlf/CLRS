package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/11 16:31
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day3 {


    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{++left, ++right};
            }
        }
        return new int[]{-1,-1};
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] == 0) {
                if (nums[fast] != 0) {
                    swap(nums, slow, fast);
                    slow++;
                }
            } else {
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        day3 d3 = new day3();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        d3.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

}
