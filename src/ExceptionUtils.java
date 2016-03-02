/**
 * Created by Gil Peretz on 02/03/2016.
 */
public class ExceptionUtils {

    public static String printStackTrace(StackTraceElement[] stackTrace) {
        String result = "";
        for (StackTraceElement element : stackTrace) {
            result+="\n\t"+element.toString();
        }
        return result;
    }
}
