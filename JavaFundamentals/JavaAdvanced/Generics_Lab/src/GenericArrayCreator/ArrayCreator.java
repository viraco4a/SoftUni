package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {

        T[] asd = (T[]) Array.newInstance(item.getClass(), length);
        for (int i = 0; i < length; i++) {
            asd[i] = item;
        }

        return asd;
    }

    public static <T> T[] create(Class<T> tClass, int length, T item) {

        T[] o = (T[]) Array.newInstance(tClass, length);
        for (int i = 0; i < o.length; i++) {
            o[i] = item;
        }

        return o;
    }
}
