
public class Pair<T1, T2>{
    private final T1 first;
    private final T2 second;

    public Pair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }

    public T1 getFirst(){
        return first;
    }
    public T2 getSecond(){
        return second;
    }

    public boolean equals(Pair<?, ?> pair){
        return equal(first, pair.first) && equal(second, pair.second);
    }
    public boolean equals(Object o){
        return o instanceof Pair<?, ?> && equals((Pair<?, ?>) o);
    }
    public static boolean equal(Object o1, Object o2){
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    public int hashCode(){
        return HashHelper.hashObjects(first, second);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
