package com.wjoansah.design_patterns.adapter.data;

import java.io.*;
import java.util.*;

public class CsvFileReader {
    private final String filePath;
    private BufferedReader reader;

    public CsvFileReader(String filePath) {
        this.filePath = filePath;
    }

    public void open() throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    public List<String> readLine() throws IOException {
        String line = reader.readLine();
        return line != null ? Arrays.asList(line.split(",")) : null;
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}
