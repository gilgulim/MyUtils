import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Gil Peretz on 07/04/2016.
 */
public class ServletHelper {
    public static Map<String, String> parseQueryString(String query){
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int index = pair.indexOf("=");
            query_pairs.put(pair.substring(0, index), pair.substring(index + 1));
        }
        return query_pairs;
    }
}
