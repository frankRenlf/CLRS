package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/23 11:44
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1768 {

    public String mergeAlternately(String word1, String word2) {
        int e1 = word1.length(), e2 = word2.length();
        int s1 = 0, s2 = 0;
        StringBuilder stringBuffer = new StringBuilder();
        for (; s1 < e1 && s2 < e2; s1++, s2++) {
            stringBuffer.append(word1.charAt(s1)).append(word2.charAt(s2));
        }
        stringBuffer.append(s1 == e1 ? word2.substring(s2) : word1.substring(s1));
        return stringBuffer.toString();
    }

}
