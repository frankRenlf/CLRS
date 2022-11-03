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

    public int maxRepeating1(String sequence, String word) {
        int ret = 0;
        String tmp = new String(word);
        while (sequence.contains(word)) {
            ret++;
            word += tmp;
        }
        return ret;
    }

    public int maxRepeating(String sequence, String word) {
        int ret = 0;
        int sl = sequence.length(), wl = word.length();
        for (int i = 0; i < sl; ) {
            int j = 0;
            int res = 0;
            while (j < wl && i + j < sl && word.charAt(j) == sequence.charAt(i + (res + 1) * j)) {
                j++;
                if (j == wl) {
                    j = 0;
                    res++;
                }
            }
            i++;
            ret = Math.max(res, ret);
        }
        return ret;
    }

}
