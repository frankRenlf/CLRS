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
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (i != i / 2) {
                    ans++;
                }
            } else {
                if (i != (n / 2 + (i - 1) / 2)) {
                    ans++;
                }
            }
        }
        return n==2?1:ans;
    }
    static T1806 t1806 = new T1806();

    public static void main(String[] args) {
        System.out.println(t1806.reinitializePermutation(6));
    }
}
