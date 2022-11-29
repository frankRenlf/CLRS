package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/29 9:47
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1758 {

    public int minOperations(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        int sub1 = 0;
        int sub0 = 0;
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (str[i] == '1') {
                sub1++;
                ret += sub0 / 2;
                sub0 = 0;
            } else {
                sub0++;
                ret += sub1 / 2;
                sub1 = 0;
            }
        }
        ret += sub1 == 0 ? sub0 / 2 : sub1 / 2;
        return ret;
    }

    public int minOperations2(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }

    static T1758 t1758 = new T1758();

    public static void main(String[] args) {
        System.out.println(t1758.minOperations("111110001"));
    }

}
