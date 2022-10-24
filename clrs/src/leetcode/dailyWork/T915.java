package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/24 10:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T915 {


    public int partitionDisjoint1(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int lm = nums[0], lp = 0, cm = nums[0];
        for (int i = 1; i < n - 1; i++) {
            cm = Math.max(cm, nums[i]);
            if (nums[i] < lm) {
                lm = cm;
                lp = i;
            }
        }
        return lp + 1;
    }
}
