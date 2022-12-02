package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/2 10:23
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1769 {

    class Solution {
        public int[] minOperations(String boxes) {
            int left = boxes.charAt(0) - '0', right = 0, operations = 0;
            int n = boxes.length();
            for (int i = 1; i < n; i++) {
                if (boxes.charAt(i) == '1') {
                    right++;
                    operations += i;
                }
            }
            int[] res = new int[n];
            res[0] = operations;
            for (int i = 1; i < n; i++) {
                operations += left - right;
                if (boxes.charAt(i) == '1') {
                    left++;
                    right--;
                }
                res[i] = operations;
            }
            return res;
        }
    }


}
