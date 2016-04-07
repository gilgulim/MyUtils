import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gil Peretz on 25/03/2016.
 */
public class CollectionHelper {
    public static <T> List<T> toList(Collection<T> collection) {
        if (collection == null) {
            return null;
        } else if (collection instanceof List) {
            return (List<T>) collection;
        }

        return new ArrayList<>(collection);
    }
}
