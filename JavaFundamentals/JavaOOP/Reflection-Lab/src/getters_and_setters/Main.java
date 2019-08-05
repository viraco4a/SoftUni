package getters_and_setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();

        Class<Reflection> reflectionClass = (Class<Reflection>) reflection.getClass();
        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();
        Method[] getters = getMethodStartsWith("get", allDeclaredMethods);
        Method[] setters = getMethodStartsWith("set", allDeclaredMethods);

        Arrays.stream(getters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    System.out.println(String.format("%s will return class %s",
                            m.getName(),
                            m.getReturnType().getSimpleName()
                            )
                    );
                });

        Arrays.stream(setters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    System.out.println(String.format("%s and will set field of class %s",
                            m.getName(),
                            m.getParameterTypes()[0]
                            )
                    );
                });
    }

    public static Method[] getMethodStartsWith(String with, Method[] methods) {
        return Arrays.stream(methods)
                .filter(m -> m.getName().startsWith(with))
                .toArray(Method[]::new);
    }
}
