package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class blackBoxIntClass = BlackBoxInt.class;

        Constructor constructor = blackBoxIntClass.getDeclaredConstructors()[1];
        constructor.setAccessible(true);

        Object o = constructor.newInstance();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split("_");
            String methodName = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            try {
                Method method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
                method.setAccessible(true);

                method.invoke(o, value);

                Field field = blackBoxIntClass.getDeclaredFields()[1];
                field.setAccessible(true);

                int result = (int) field.get(o);
                System.out.println(result);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
