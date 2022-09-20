package leetcode.stage3;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/20 10:01
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day10 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int target = Arrays.stream(nums).sum() / k;
        if (nums[n - 1] > target) {
            return false;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        int[] bucket = new int[k];
        return backTrack(nums, n, bucket, k, 0, target);
    }

    private boolean backTrack(int[] nums, int n, int[] bucket, int k, int index, int target) {
        if (index == n) return true;
        for (int i = 0; i < k; i++) {
            if (i > 0 && index == 0) break;
            if (bucket[i] + nums[index] > target) continue;
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            bucket[i] += nums[index];
            if (backTrack(nums, n, bucket, k, index + 1, target)) return true;
            bucket[i] -= nums[index];
        }
        return false;
    }

    static Day10 d10 = new Day10();

    public static void main(String[] args) {
        long cur = System.currentTimeMillis();
        System.out.println(d10.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(System.currentTimeMillis() - cur);

    }
}
