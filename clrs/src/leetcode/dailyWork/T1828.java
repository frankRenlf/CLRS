package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/24 9:45
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int m = points.length, n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int cx = queries[i][0], cy = queries[i][1], cr = queries[i][2];
            for (int[] point : points) {
                int px = point[0], py = point[1];
                if ((cx - px) * (cx - px) + (cy - py) * (cy - py) <= cr * cr) {
                    ++ans[i];
                }
            }
        }
        return ans;
    }
}
