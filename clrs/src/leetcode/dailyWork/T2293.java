package leetcode.dailyWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/15 9:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2293 {

    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            int[] newNums = new int[n / 2];
            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
            n /= 2;
        }
        return nums[0];
    }

}
