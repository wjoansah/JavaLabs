package com.wjoansah.classloaders;

import java.lang.reflect.Method;

public class CustomClassLoaderTest {
    public static void main(String[] args) {
        // Define the directory containing the compiled .class files
        String classDirectory = "classes/";

        // Create an instance of the custom class loader
        DirectoryClassLoader classLoader = new DirectoryClassLoader(classDirectory);

        try {
            // Load a specific class by name
            Class<?> loadedClass = classLoader.loadClass("com.wjoansah.classloaders.classes.Shape");

            // Instantiate the loaded class
            Object instance = loadedClass.getDeclaredConstructor().newInstance();

            // Use reflection to call a method on the loaded class
            Method method = loadedClass.getMethod("getArea");
            method.invoke(instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
