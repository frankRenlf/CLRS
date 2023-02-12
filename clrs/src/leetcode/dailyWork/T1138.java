package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/12 9:46
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1138 {

    public String alphabetBoardPath(String target) {
        char[] arr = target.toCharArray();
        StringBuilder cnt = new StringBuilder();
        int pre_x = 0, pre_y = 0;
        for (char c :
                arr) {
            int len = c - 'a';
            int x = len % 5, y = len / 5;
            int div_x = x - pre_x;
            int div_y = y - pre_y;
            if(c=='z'){
                while (div_x < 0) {
                    cnt.append('L');
                    div_x++;
                }
                while (div_x > 0) {
                    cnt.append('R');
                    div_x--;
                }
                while (div_y < 0) {
                    cnt.append('U');
                    div_y++;
                }
                while (div_y > 0) {
                    cnt.append('D');
                    div_y--;
                }
            }else {
                while (div_y < 0) {
                    cnt.append('U');
                    div_y++;
                }
                while (div_y > 0) {
                    cnt.append('D');
                    div_y--;
                }
                while (div_x < 0) {
                    cnt.append('L');
                    div_x++;
                }
                while (div_x > 0) {
                    cnt.append('R');
                    div_x--;
                }
            }

            cnt.append('!');
            pre_x = x;
            pre_y = y;
        }
        return cnt.toString();
    }

    static T1138 t1138 = new T1138();

    public static void main(String[] args) {
        System.out.println(t1138.alphabetBoardPath("code"));
    }

}
