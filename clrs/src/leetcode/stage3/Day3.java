package leetcode.stage3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/14 9:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day3 {

    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int sub = n / 20;
        double sum = 0.0;
        for (int i = sub; i < n - sub; i++) {
            sum += arr[i];
        }
        return sum / (n - sub * 2);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || n == 0) return ret;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (sum == 0) {
                    ret.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                } else {
                    while (left < right && nums[left] == nums[++left]) ;
                }
            }
        }
        return ret;
    }

    static Day3 day3 = new Day3();

    public static void main(String[] args) {
        System.out.println(day3.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
