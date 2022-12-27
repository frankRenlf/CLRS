package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/27 12:05
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2027 {

    public int minimumMoves(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                cnt++;
                i += 2;
            }
        }
        return cnt;
    }

    static T2027 t2027 = new T2027();

    public static void main(String[] args) {
        System.out.println(t2027.minimumMoves("XXOX"));
    }

}
