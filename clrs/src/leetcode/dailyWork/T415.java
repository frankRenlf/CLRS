package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/21 16:09
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T415 {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        StringBuilder ret = new StringBuilder();
        int add = 0;
        while (l1 >= 0 || l2 >= 0 || add != 0) {
            int el1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int el2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int result = el1 + el2 + add;
            ret.append(result % 10);
            add = result / 10;
            l1--;
            l2--;
        }
        ret.reverse();
        return ret.toString();
    }
}
