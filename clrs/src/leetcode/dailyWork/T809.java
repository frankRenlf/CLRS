package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/25 10:06
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T809 {


    public int expressiveWords(String s, String[] words) {
        int n = s.length(), ans = 0;
        out:
        for (String word : words) {
            int m = word.length(), i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) != word.charAt(j)) continue out;
                int a = i, b = j;
                while (a < n && s.charAt(a) == s.charAt(i)) a++;
                while (b < m && word.charAt(b) == word.charAt(j)) b++;
                a -= i;
                b -= j;
                if (a != b && (b > a || a < 3)) continue out;
                i += a;
                j += b;
            }
            if (i == n && j == m) ans++;
        }
        return ans;
    }

}
