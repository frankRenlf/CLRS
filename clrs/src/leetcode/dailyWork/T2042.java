package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/3 20:35
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2042 {
    public boolean areNumbersAscending(String s) {
        int x = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int val = s.charAt(i) - '0';
                if (x > val) {
                    return false;
                } else {
                    x = val;
                }
            }
        }
        return true;
    }
}
