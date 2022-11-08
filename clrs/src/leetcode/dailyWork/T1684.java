package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/8 11:58
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        char[] arr = new char[26];
        for (char c : allowed.toCharArray()) {
            arr[c - 'a'] = 1;
        }
        int ret = 0;
        for (String s : words) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (arr[c - 'a'] == 0) {
                    break;
                }
                i++;
            }
            if (i == s.length()) ret++;
        }
        return ret;
    }

}
