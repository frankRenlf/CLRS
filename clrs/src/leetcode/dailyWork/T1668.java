package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/3 15:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1668 {

    public int maxRepeating(String sequence, String word) {
        int ret = 0;
        int sl = sequence.length(), wl = word.length();
        for (int i = 0; i < sl; i++) {
            int j = 0;
            while (word.charAt(j) == sequence.charAt(i + j)) {
                while (j < wl && word.charAt(j) == sequence.charAt(i + j)) {
                    j++;
                }
                ret += j == wl ? 1 : 0;
                i += j;
                j = 0;
            }
        }
        return ret;
    }

}
