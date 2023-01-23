package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/23 9:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2303 {

    public double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        double div = 100.0;
        int pre = 0;
        for (int[] el : brackets) {
            if (income > el[0]) {
                res += (el[0] - pre) * el[1] / div;
                pre = el[0];
            } else {
                res += (income - pre) * el[1] / div;
            }
        }
        return res;
    }

    static T2303 t2303 = new T2303();

    public static void main(String[] args) {
        System.out.println(t2303.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
    }

}
