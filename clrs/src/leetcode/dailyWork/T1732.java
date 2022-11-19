package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/19 11:13
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1732 {

    public int largestAltitude(int[] gain) {
        int high = 0;
        int level = 0;
        for (int x : gain) {
            level += x;
            high = Math.max(high, level);
        }
        return high;
    }

}
