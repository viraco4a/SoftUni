package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class richSoilLandClass = RichSoilLand.class;

        Field[] declaredFields = richSoilLandClass.getDeclaredFields();

        String command = "";

        while (!"HARVEST".equals(command=reader.readLine())) {
            switch (command) {
                case "private":
                    printPrivateFields(declaredFields);
                    break;
                case "protected":
                    printProtectedFields(declaredFields);
                    break;
                case "public":
                    printPublicFields(declaredFields);
                    break;
                case "all":
                    printAllFields(declaredFields);
                    break;
            }
        }
    }

    private static void printPrivateFields(Field[] fields) {
        Arrays.stream(fields)
                .filter(f -> Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(String.format("%s %s %s", Modifier.toString(f.getModifiers()),
                        f.getType().getSimpleName(),
                        f.getName())));
    }

    private static void printProtectedFields(Field[] fields) {
        Arrays.stream(fields)
                .filter(f -> Modifier.isProtected(f.getModifiers()))
                .forEach(f -> System.out.println(String.format("%s %s %s", Modifier.toString(f.getModifiers()),
                        f.getType().getSimpleName(),
                        f.getName())));
    }

    private static void printPublicFields(Field[] fields) {
        Arrays.stream(fields)
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .forEach(f -> System.out.println(String.format("%s %s %s", Modifier.toString(f.getModifiers()),
                        f.getType().getSimpleName(),
                        f.getName())));
    }

    private static void printAllFields(Field[] fields) {
        Arrays.stream(fields)
                .forEach(f -> System.out.println(String.format("%s %s %s",
                        Modifier.toString(f.getModifiers()),
                        f.getType().getSimpleName(),
                        f.getName())));
    }
}