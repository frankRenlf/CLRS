package leetcode.stage3;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/12 12:32
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day1 {

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0; i--) {
            int x = n - i;
            if (nums[i] >= x && (i == 0 || nums[i - 1] < x)) return x;
        }
        return -1;
    }

    static day1 d1 = new day1();

    public static void main(String[] args) {
        System.out.println(d1.specialArray(new int[]{3, 6, 7, 7, 0}));
    }

}
