package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/28 9:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1664 {

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int oddVal = 0, evenVal = 0;
        int[] odd = new int[n];
        int[] even = new int[n];
        for (int i = n-1; i >=0; i--) {
            if (i % 2 == 0) {
                evenVal += nums[i];
            } else {
                oddVal += nums[i];
            }
        }

    }

}
