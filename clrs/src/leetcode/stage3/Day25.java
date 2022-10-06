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

    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int x : arr) {
            cnt += x;
        }
        if (cnt % 3 != 0) {
            return new int[]{-1, -1};
        } else if (cnt == 0) {
            return new int[]{0, n - 1};
        }
        cnt /= 3;
        int[] pos = new int[]{find(arr, 1), find(arr, cnt + 1), find(arr, cnt * 2 + 1)};
        boolean key = true;
        while (pos[2] < n) {
            for (int i = 1; i < 3; i++) {
                if (arr[pos[i - 1]] != arr[pos[i]]) {
                    key = false;
                    break;
                }
            }
            if (!key) break;
            for (int i = 0; i < 3; i++) {
                pos[i]++;
            }
        }
        return pos[2] == n ? new int[]{pos[0] - 1, pos[1]} : new int[]{-1, -1};
    }

    private int find(int[] arr, int x) {
        int i = 0;
        for (; x > 0; i++) {
            x -= arr[i];
        }
        return i;
    }

}
