package leetcode.stage2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/4 12:26
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day12 {

    public int numSpecial(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] rowSum = new int[row], colSum = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                colSum[j] += mat[i][j];
                rowSum[i] += mat[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && colSum[j] == 1 && rowSum[i] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

}
