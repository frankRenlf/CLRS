package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/13 11:14
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T769 {

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int ret = 0;
        int pos = 0;
        for (int i = 0; i < n; ) {
            if (arr[i] <= i && pos <= i) {
                ret++;
            } else {
                pos = Math.max(pos, arr[i]);
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        T769 t769 = new T769();
        System.out.println(t769.maxChunksToSorted(new int[]{1,0,2,3,4}));
    }

}
