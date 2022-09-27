package leetcode.stage3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/27 10:24
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day18 {

    public boolean CheckPermutation(String s1, String s2) {
        int[] arr = new int[58];
        for (char x : s1.toCharArray()) {
            arr[x - 'A'] += 1;
        }
        for (char x : s2.toCharArray()) {
            arr[x - 'A'] -= 1;
            if (arr[x - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }

}
