import java.util.*;

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

    public static boolean isCollectionEmpty(Collection list) {
        return list == null || list.isEmpty();
    }
    public static boolean isCollectionNotEmpty(Collection list) {
        return !isCollectionEmpty(list);
    }
    public static boolean isMapEmpty(Map map) {
        return map == null || map.isEmpty();
    }
    public static boolean isMapNotEmpty(Map map) {
        return !isMapEmpty(map);
    }
    public static boolean isArrayEmpty(Object[] array) {
        return array == null || array.length == 0;
    }
    public static boolean isArrayNotEmpty(Object[] array) {
        return !isArrayEmpty(array);
    }
    public static boolean isSetEmpty(String set) {
        return set == null || set.isEmpty();
    }
    public static boolean isSetNotEmpty(String set) {
        return !isSetEmpty(set);
    }

    public static boolean isCollectionSize(int size, Collection list) {
        return list != null && list.size() == size;
    }

    public static <T, V> boolean isMapEmptyOrWithNullValues(Map<T, V> map) {
        if (CollectionHelper.isMapEmpty(map)) {
            return true;
        } else {
            for (V value : map.values()) {
                if (value == null) {
                    return true;
                }
            }
        }

        return false;
    }
    public static <T, S> Pair<List<T>, List<S>> listOfPairs2PairOfLists(final List<? extends Pair<T, S>> listOfPairs) {
        List<T> firstList = new AbstractList<T>() {
            @Override
            public T get(int index) {
                return listOfPairs.get(index).getFirst();
            }

            @Override
            public int size() {
                return listOfPairs.size();
            }
        };

        List<S> secondList = new AbstractList<S>() {
            @Override
            public S get(int index) {
                return listOfPairs.get(index).getSecond();
            }

            @Override
            public int size() {
                return listOfPairs.size();
            }
        };

        return new Pair<>(firstList, secondList);
    }

    public static <T, S> List<Pair<T, S>> pairOfLists2ListOfPairs(final List<T> firstList, final List<S> secondList) {
        return new AbstractList<Pair<T, S>>() {
            @Override
            public Pair<T, S> get(int index) {
                return new Pair<>(firstList.get(index), secondList.get(index));
            }

            @Override
            public int size() {
                return Math.min(firstList.size(), secondList.size());
            }
        };
    }
}
