package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/4 10:48
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T754 {

    public int reachNumber(int target) {
        if (target < 0) target = -target;
        int k = (int) Math.sqrt(2 * target), dist = k * (k + 1) / 2;
        while (dist < target || (dist - target) % 2 == 1) {
            k++;
            dist = k * (k + 1) / 2;
        }
        return k;
    }

}
