package leetcode.dailyWork;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/10 10:26
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1691 {

    public int maxHeight(int[][] cuboids) {
        for (int[] c : cuboids) Arrays.sort(c);
        Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int ans = 0, n = cuboids.length;
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j)
                // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2])
                    f[i] = Math.max(f[i], f[j]); // cuboids[j] 可以堆在 cuboids[i] 上
            f[i] += cuboids[i][2];
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

}
