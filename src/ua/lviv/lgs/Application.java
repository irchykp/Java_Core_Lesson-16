package ua.lviv.lgs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// 1
		Class<Car> cc = Car.class;
		System.out.println("Full name of current class: " + cc.getName());
		System.out.println("Simple name of current class: " + cc.getSimpleName());
		System.out.println("Modifier of current class: " + Modifier.toString(cc.getModifiers()));
		System.out.println("Package of current class: " + cc.getPackage());
		System.out.println("Superclass : " + cc.getSuperclass());
		System.out.println("Interfaces : " + Arrays.toString(cc.getInterfaces()));
		System.out.println("Constructors: " + Arrays.toString(cc.getConstructors()));

		System.out.println();

		Field[] fields = cc.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		System.out.println();

		fields = cc.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		System.out.println();

		Method[] methods = cc.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method);
		}
		System.out.println();
		Constructor<Car> constructor = cc.getConstructor(String.class, int.class, double.class);
		Car newInstanceCar = constructor.newInstance("Ferrari", 320, 1000000.0);
		System.out.println("My car is" + newInstanceCar);
		System.out.println();

		// 2
		Field modelField = cc.getField("model");
		modelField.set(newInstanceCar, "FerrariF360");
		System.out.println("New model :" + newInstanceCar);
		System.out.println();

		// 3

		Method myMethod = Car.class.getDeclaredMethod("myMethod",String.class,int.class);
		myMethod.setAccessible(true);
		myMethod.invoke(newInstanceCar, "test", 3);
		System.out.println();
		
		myMethod = Car.class.getDeclaredMethod("myMethod",String.class);
		myMethod.setAccessible(true);
		myMethod.invoke(newInstanceCar, "test");

	}
}
