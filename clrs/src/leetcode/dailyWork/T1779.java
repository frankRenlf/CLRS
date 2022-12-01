package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/1 15:14
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int ret = -1;
        int val = Integer.MAX_VALUE;
        int tmp = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                tmp = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (tmp < val) {
                    val = tmp;
                    ret = i;
                }
            }
        }
        return ret;
    }

}
