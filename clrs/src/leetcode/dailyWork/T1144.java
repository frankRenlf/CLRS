package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/27 9:45
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1144 {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(help(nums, 0), help(nums, 1));
    }

    public int help(int[] nums, int pos) {
        int len = nums.length;
        int ret = 0;
        for (int i = pos; i < len; i += 2) {
            int ans = 0;
            if (i - 1 >= 0) {
                ans = Math.max(ans, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                ans = Math.max(ans, nums[i] - nums[i + 1] + 1);
            }
            ret += ans;
        }
        return ret;
    }

}
