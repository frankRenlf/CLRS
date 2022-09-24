package leetcode.stage3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/24 10:14
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day15 {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;
        int[] sum = new int[n * 2 + 10];
        for (int i = 1; i <= 2 * n; i++) sum[i] += sum[i - 1] + code[(i - 1) % n];
        for (int i = 1; i <= n; i++) {
            if (k < 0) ans[i - 1] = sum[i + n - 1] - sum[i + n + k - 1];
            else ans[i - 1] = sum[i + k] - sum[i];
        }
        return ans;
    }

}
