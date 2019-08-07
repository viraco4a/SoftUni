package barracksWars.core;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
		try {
			commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
			Class klass = Class.forName("barracksWars.core.commands." + commandName);
			Constructor constructor = klass.getDeclaredConstructor(String[].class);
			constructor.setAccessible(true);

			Executable command = (Executable) constructor.newInstance((Object) data);

			Field[] dependencies = this.getClass().getDeclaredFields();
			Field[] fields = klass.getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(Inject.class)) {
					Class type = field.getType();
					for (Field dependency : dependencies) {
						dependency.setAccessible(true);
						if (dependency.getType().equals(type)) {
							field.set(command, dependency.get(this));
						}
					}
				}
			}
			return command.execute();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
    }
}
