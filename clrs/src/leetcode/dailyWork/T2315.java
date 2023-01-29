package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/29 17:14
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2315 {

    public int countAsterisks(String s) {
        int count = 0;
        int ret = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                count++;
            }
            if (c == '*' && (count % 2) == 0) {
                ret++;
            }
        }
        return ret;
    }

}
