package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/28 9:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1664 {

    public int waysToMakeFair(int[] nums) {
        // 预处理 x为偶数下标和 y为奇数下标和
        int x = 0, y = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                x += nums[i];
            } else {
                y += nums[i];
            }
        }
        // pre_x 不受下标改变的偶数和 pre_y 同理
        int ans = 0, pre_x = 0, pre_y = 0;
        // 枚举每一个删除的下标
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                x -= nums[i];
            } else {
                y -= nums[i];
            }
            // 删除后，后续数字的下标发生转换
            if (y + pre_x == x + pre_y) ans++;

            // 当前数字在后续的删除中不受下标改变
            if ((i & 1) == 0) {
                pre_x += nums[i];
            } else {
                pre_y += nums[i];
            }

        }
        return ans;
    }

}
