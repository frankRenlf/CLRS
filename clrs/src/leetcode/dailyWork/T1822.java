package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/27 10:33
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1822 {

    public int arraySign(int[] nums) {
        int num = 0;
        for (int x : nums) {
            if (x == 0) {
                return 0;
            }
            if (x < 0) {
                num++;
            }
        }
        return num % 2 == 0 ? 1 : -1;
    }

}
