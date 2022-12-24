package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/25 1:33
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1739 {

    public int minimumBoxes(int n) {
        int i = (int) Math.pow(6.0 * n, 1.0 / 3);
        if (g(i) < n) {
            i++;
        }
        n -= g(i - 1);
        int j = (int) Math.ceil((Math.sqrt((long) 8 * n + 1) - 1) / 2);
        return (i - 1) * i / 2 + j;
    }

    public long g(int x) {
        return (long) x * (x + 1) * (x + 2) / 6;
    }

}
