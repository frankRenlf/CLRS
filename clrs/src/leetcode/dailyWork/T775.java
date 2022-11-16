package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/16 14:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T775 {

    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, minVal = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minVal) {
                return false;
            }
            minVal = Math.min(minVal, nums[i + 1]);
        }
        return true;
    }


}
