package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/28 10:25
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1750 {

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            while (left + 1 < right && s.charAt(left) == s.charAt(left + 1)) {
                left++;
            }
            while (left < right - 1 && s.charAt(right - 1) == s.charAt(right)) {
                right--;
            }
            left++;
            right--;
        }
        return right - left + 1;
    }

    static T1750 t1750 = new T1750();

    public static void main(String[] args) {
        System.out.println(t1750.minimumLength("ca"));
    }

}
