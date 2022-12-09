package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/9 10:19
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1780 {

    public boolean checkPowersOfThree(int n) {
        while (n > 1) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

}
