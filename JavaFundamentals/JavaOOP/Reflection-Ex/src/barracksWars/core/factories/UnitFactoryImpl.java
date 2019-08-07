package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		String unitTotalName = UNITS_PACKAGE_NAME + unitType;

		try {
			Class klass = Class.forName(unitTotalName);

			Constructor constructor = klass.getDeclaredConstructors()[0];
			constructor.setAccessible(true);

			return (Unit) constructor.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		throw new ExecutionControl.NotImplementedException("message");
	}
}
