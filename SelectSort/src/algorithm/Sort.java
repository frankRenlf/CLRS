package algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SelectSort
 * @Package : Sort
 * @createTime : 2022/7/22 13:57
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Sort {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void selectSort(int[] nums) {
        for (int cur = 1; cur < nums.length; cur++) {
            int key = nums[cur];
            int pre = cur - 1;
            while (pre >= 0 && key < nums[pre]) {
                nums[pre + 1] = nums[pre];
                pre--;
            }
            nums[pre + 1] = key;
        }
    }

}
