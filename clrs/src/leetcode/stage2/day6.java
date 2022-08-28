package leetcode.stage2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/28 16:10
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day6 {

    public int preimageSizeFZF(int k) {
        if (k <= 1) return 5;
        return f(k) - f(k - 1);
    }

    private int f(int k) {
        long left = 0, right = (long) 1e10;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (countZero(mid) > k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) right;
    }

    private int countZero(long n) {
        int count = 0;
        while (n != 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    static day6 d6 = new day6();

    public static void main(String[] args) {
        System.out.println(d6.preimageSizeFZF(3));
    }

}
