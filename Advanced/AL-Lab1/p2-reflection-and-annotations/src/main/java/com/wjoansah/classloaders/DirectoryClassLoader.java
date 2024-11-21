package com.wjoansah.classloaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirectoryClassLoader extends ClassLoader {
    private final String directoryPath;

    public DirectoryClassLoader(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // Convert the class name to a file path
        String filePath = directoryPath + "/" + name.replace('.', '/') + ".class";
        File classFile = new File(filePath);

        // If the class file doesn't exist, throw an exception
        if (!classFile.exists()) {
            throw new ClassNotFoundException("Class " + name + " not found in " + directoryPath);
        }

        try {
            // Load the byte code of the class file
            byte[] classData = Files.readAllBytes(Paths.get(classFile.toURI()));

            // Define the class in the JVM and return it
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class " + name, e);
        }
    }
}
