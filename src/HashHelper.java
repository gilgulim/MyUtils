/**
 * Created by Gil Peretz on 02/06/2016.
 */
public class HashHelper{


    public static int hashObjects(Object ... args){
        int result = 0;
        for (Object o : args){
            result *= 31;
            if (o != null)
                result += o.hashCode();
        }
        return result;
    }

    public static int hashObjects(Object o1, Object o2){
        int result = o1 != null ? o1.hashCode() : 0;
        result = 31 * result + (o2 != null ? o2.hashCode() : 0);
        return result;
    }


    public static int hashInts(int ... args){
        int result = 0;
        for (int i : args)
            result = 31*result + i;
        return result;
    }


    public static int hashDouble(double val){
        long bits = Double.doubleToLongBits(val);
        return (int)(bits ^ (bits >>> 32));
    }


    public static int hashFloat(float val){
        return Float.floatToIntBits(val);
    }



}
