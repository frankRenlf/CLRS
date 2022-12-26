package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/26 10:51
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1759 {

    public int countHomogenous(String s) {
        char[] arr = s.toCharArray();
        int ret = 0;

        for (int i = 0; i < arr.length; ) {
            int k = i;
            while (i < arr.length && arr[k] == arr[i]) {
                ret += i - k + 1;
                ret %= 1000000007;
                i++;
            }
        }
        return ret;
    }

    static T1759 t1759 = new T1759();

    public static void main(String[] args) {
        System.out.println(t1759.countHomogenous("xy"));
    }

}
