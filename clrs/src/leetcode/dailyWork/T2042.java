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
        String[] arr = s.split(" ");
        for (String value : arr) {
            if (Character.isDigit(value.charAt(0))) {
                int val = Integer.parseInt(value);
                if (x >= val) {
                    return false;
                } else {
                    x = val;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("123"));
    }
}
