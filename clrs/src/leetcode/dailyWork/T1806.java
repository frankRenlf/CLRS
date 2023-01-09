package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/9 10:45
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1806 {
    public int reinitializePermutation(int n) {
        if (n == 2) {
            return 1;
        }
        int step = 1, pow2 = 2;
        while (pow2 != 1) {
            step++;
            pow2 = pow2 * 2 % (n - 1);
        }
        return step;
    }

    static T1806 t1806 = new T1806();

    public static void main(String[] args) {
        System.out.println(t1806.reinitializePermutation(6));
    }
}
