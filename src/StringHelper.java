/**
 * Created by Gil Peretz on 06/03/2016.
 */
public class StringHelper {
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static boolean areEqual(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        } else if (str2 == null) {
            return false;
        }

        return str1.equals(str2);
    }

    public static boolean isNullOrEmptyOrBlank(String str){
        return str == null || str.trim().length() == 0;
    }
}
