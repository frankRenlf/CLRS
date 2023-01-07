package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/7 12:07
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1658 {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] += sum[i - 1] + nums[i];
        }
        if (sum[len - 1] < x) return -1;
        
    }
}
