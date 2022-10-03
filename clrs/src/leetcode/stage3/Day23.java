package leetcode.stage3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/10/3 9:47
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day23 {

    public boolean checkOnesSegment(String s) {
        int end = s.length() - 1;
        int count = 0;
        while (end >= 0) {
            if (s.charAt(end) == '1') {
                count++;
                if (count > 1) return false;
                while (end >= 0 && s.charAt(end) == '1') {
                    end--;
                }
            } else {
                end--;
            }
        }
        return true;
    }

}
