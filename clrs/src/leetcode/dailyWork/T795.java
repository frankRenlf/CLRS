package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/24 8:44
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ret = 0;
        int l = 1, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) l = i;
            if (nums[i] >= left) r = i;
            ret += r - l;
        }
        return ret;
    }

    public static void main(String[] args) {
        T795 t795 = new T795();
        System.out.println(t795.numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8));
    }

}
