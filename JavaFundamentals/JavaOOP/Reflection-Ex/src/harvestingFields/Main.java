package harvestingFields;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RichSoilLand richSoilLand = new RichSoilLand();
        Class klass = richSoilLand.getClass();

        String line;
        while (!"HARVEST".equals(line = reader.readLine())) {
            Field[] declaredFields = klass.getDeclaredFields();
            StringBuilder sb = new StringBuilder();

            if (line.equals("all")) {
                Arrays.stream(declaredFields)
                        .forEach(field -> {
                            String currentMod = getModifier(field.getModifiers());
                            sb.append(String.format("%s %s %s",
                                    currentMod,
                                    field.getType().getSimpleName(),
                                    field.getName())
                            ).append(System.lineSeparator());
                        });
                System.out.println(sb.toString().trim());
                continue;
            }
            String input = line;
			Arrays.stream(declaredFields)
					.filter(field -> {
						String currentMod = getModifier(field.getModifiers());
						return currentMod.equals(input);
					}).forEach(field -> {
						sb.append(String.format("%s %s %s",
								input,
								field.getType().getSimpleName(),
								field.getName()
						)).append(System.lineSeparator());
			});
			System.out.println(sb.toString());
        }
    }

    private static String getModifier(int mod) {
        if (Modifier.isProtected(mod)) {
            return "protected";
        } else {
            return "private";
        }
    }
}