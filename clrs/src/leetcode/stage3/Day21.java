package leetcode.stage3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/10/1 11:04
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day21 {

    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pl; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[sl][pl];
    }

    public String reformatNumber(String number) {
        char[] arr = number.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                str.append(arr[i]);
            }
        }
        System.out.println(str);
        int len = str.length();
        // 2 4
        int tail = len % 3 == 1 ? 4 : len % 3;
        int sub = tail == 4 ? len / 3 - 1 : len / 3;
        System.out.println(tail + " " + sub);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < sub; i++) {
            ret.append(str.substring(i * 3, i * 3 + 3)).append("-");
        }
        for (int i = 3 * sub; i < len; i += 2) {
            ret.append(str.substring(i, i + 2)).append("-");
        }
        return ret.deleteCharAt(ret.length() - 1).toString();
    }

    static Day21 day21 = new Day21();

    public static void main(String[] args) {
        System.out.println(day21.reformatNumber("123 4-5678"));
    }

}
