package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/18 10:06
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day9 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int oldColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor || color == oldColor) {
            return;
        }
        image[sr][sc] = color;
        fill(image, sr - 1, sc, color, oldColor);
        fill(image, sr, sc + 1, color, oldColor);
        fill(image, sr + 1, sc, color, oldColor);
        fill(image, sr, sc - 1, color, oldColor);
    }


    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, countArea(grid, i, j));
                }
            }
        }
        return max;
    }

    private int countArea(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        return countArea(grid, i - 1, j) + countArea(grid, i, j + 1) + countArea(grid, i + 1, j) + countArea(grid, i, j - 1) + 1;
    }

}
