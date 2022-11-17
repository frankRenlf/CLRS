package leetcode.dailyWork;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/17 10:02
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T792 {

    public int numMatchingSubseq(String s, String[] words) {
        Queue<int[]>[] p = new Queue[26];
        for (int i = 0; i < 26; ++i) {
            p[i] = new ArrayDeque<int[]>();
        }
        for (int i = 0; i < words.length; ++i) {
            p[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int len = p[c - 'a'].size();
            while (len > 0) {
                int[] t = p[c - 'a'].poll();
                if (t[1] == words[t[0]].length() - 1) {
                    ++res;
                } else {
                    ++t[1];
                    p[words[t[0]].charAt(t[1]) - 'a'].offer(t);
                }
                --len;
            }
        }
        return res;
    }

}
