package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/1 10:54
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2351 {

    public char repeatedCharacter(String s) {
        int[] arr = new int[26];
        char ret = 'a';
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            arr[pos] += 1;
            if (arr[pos] >= 2) {
                ret = s.charAt(i);
                break;
            }
        }
        return ret;
    }

}
