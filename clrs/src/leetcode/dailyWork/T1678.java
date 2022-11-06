package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/6 16:51
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1678 {

    public String interpret(String command) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < command.length(); ) {
            if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    stringBuffer.append('o');
                    i += 2;
                } else {
                    stringBuffer.append("al");
                    i += 4;
                }
            } else {
                stringBuffer.append('G');
                i += 1;
            }
        }
        return stringBuffer.toString();
    }

}
