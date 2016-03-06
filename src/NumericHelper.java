/**
 * Created by Gil Peretz on 06/03/2016.
 */
public class NumericHelper {
    public static long safeDivide(long num1, long num2) {
        if (num2 == 0)
            return 0;
        return num1 / num2;
    }
}
