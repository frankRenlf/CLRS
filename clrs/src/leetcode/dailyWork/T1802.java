package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/4 12:05
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1802 {

    public int maxValue(int n, int index, int maxSum) {
        double left = index;
        double right = n - index - 1;
        if (left > right) {
            double temp = left;
            left = right;
            right = temp;
        }

        double upper = ((double) (left + 1) * (left + 1) - 3 * (left + 1)) / 2 + left + 1 + (left + 1) + ((left + 1) * (left + 1) - 3 * (left + 1)) / 2 + right + 1;
        if (upper >= maxSum) {
            double a = 1;
            double b = -2;
            double c = left + right + 2 - maxSum;
            return (int) Math.floor((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
        }

        upper = ((double) 2 * (right + 1) - left - 1) * left / 2 + (right + 1) + ((right + 1) * (right + 1) - 3 * (right + 1)) / 2 + right + 1;
        if (upper >= maxSum) {
            double a = 1.0 / 2;
            double b = left + 1 - 3.0 / 2;
            double c = right + 1 + (-left - 1) * left / 2 - maxSum;
            return (int) Math.floor((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
        } else {
            double a = left + right + 1;
            ;
            double b = (-left * left - left - right * right - right) / 2 - maxSum;
            return (int) Math.floor(-b / a);
        }
    }

}
