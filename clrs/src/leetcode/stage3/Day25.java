package leetcode.stage3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/10/6 9:57
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day25 {

    private int[] arr;

    public int[] threeEqualParts(int[] arr) {
        this.arr = arr;
        int cnt = 0;
        int n = arr.length;
        for (int v : arr) {
            cnt += v;
        }
        if (cnt % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (cnt == 0) {
            return new int[]{0, n - 1};
        }
        cnt /= 3;

        int i = find(1), j = find(cnt + 1), k = find(cnt * 2 + 1);
        while (k < n && arr[i] == arr[j] && arr[j] == arr[k]) {
            ++i;
            ++j;
            ++k;
        }
        // i,j,n
        // 0 i-1, i j-1
        // 0 i-1, i j-1, j n-1;
        return k == n ? new int[]{i - 1, j} : new int[]{-1, -1};
    }

    private int find(int x) {
        int s = 0;
        for (int i = 0; i < arr.length; ++i) {
            s += arr[i];
            if (s == x) {
                return i;
            }
        }
        return 0;
    }

}
