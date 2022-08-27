package leetcode.stage1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/12 8:18
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day4 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public String reverseWords(String s) {
        StringBuilder ret = new StringBuilder();
        int len = s.length();
        int left = 0;
        int right = 0;
        while (right < len) {
            if (s.charAt(right) == ' ') {
                swap(s, ret, left, right - 1);
                ret.append(' ');
                left = right + 1;
            }
            right++;
            if (right == len) {
                swap(s, ret, left, right - 1);
            }
        }
        return ret.toString();
    }

    // for java, String can not be changed, so it must cost other space
    private void swap(String s, StringBuilder ret, int left, int right) {
        while (left <= right) {
            ret.append(s.charAt(right));
            right--;
        }
    }

}
