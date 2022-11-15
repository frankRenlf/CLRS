package leetcode.dailyWork;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/11/15 10:01
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int ret = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] <= truckSize) {
                ret += boxType[1] * boxType[0];
                truckSize -= boxType[0];
            } else {
                ret += boxType[1] * truckSize;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T1710 t1710 = new T1710();
        System.out.println(t1710.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
    }

}
