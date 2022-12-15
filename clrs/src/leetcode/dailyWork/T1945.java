package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/15 12:52
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1945 {

    public int getLucky(String s, int k) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            str.append(c - 'a' + 1);
        }
        while (str.length() > 1 && k > 0) {
            int n = 0;
            for (int i = 0; i < str.length(); i++) {
                n += str.charAt(i) - '0';
            }
            str = new StringBuilder(Integer.toString(n));
            k--;
        }
        return Integer.parseInt(str.toString());
    }

    static T1945 t1945 = new T1945();

    public static void main(String[] args) {
        System.out.println(t1945.getLucky("iiii", 1));
    }

}

