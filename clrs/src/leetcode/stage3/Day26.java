package leetcode.stage3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/10/7 11:01
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day26 {

    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int ret = 0;
        int i = 0, cur = 0;
        while (i < n) {
            cur = nums[i++];
            while (i < n && nums[i - 1] < nums[i]) {
                cur += nums[i++];
            }
            ret = Math.max(ret, cur);
        }

        return ret;
    }

}
