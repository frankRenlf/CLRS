package leetcode.stage2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/26 10:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day3 {

    public int maxProduct(int[] nums) {
        int first = nums[0], second = nums[1];
        if (first < second) {
            first = second;
            second = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }

}
