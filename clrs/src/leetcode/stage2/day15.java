package leetcode.stage2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/7 9:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day15 {

    public String reorderSpaces(String text) {
        int count = 0, num = 0;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            } else {
                num++;
                while (text.charAt(i) != ' ') {
                    i++;
                }
            }

        }
        int sub = count /
        return ret.toString();
    }

    static day15 d15 = new day15();

    public static void main(String[] args) {
        System.out.println(d15.reorderSpaces("  this   is  a sentence "));
    }


}
