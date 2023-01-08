package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/8 10:06
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2185 {
    public int prefixCount(String[] words, String pref) {
        int ret = 0;
        for (String s : words) {
            if (s.indexOf(pref) == 0) {
                ret++;
            }
        }
        return ret;
    }
}
