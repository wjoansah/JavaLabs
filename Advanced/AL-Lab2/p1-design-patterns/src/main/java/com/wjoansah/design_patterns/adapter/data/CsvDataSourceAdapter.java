package com.wjoansah.design_patterns.adapter.data;

import java.io.IOException;
import java.util.*;

public class CsvDataSourceAdapter implements DataSource {
    private final CsvFileReader csvFileReader;
    private List<String> headers;

    public CsvDataSourceAdapter(String filePath) {
        this.csvFileReader = new CsvFileReader(filePath);
    }

    @Override
    public void connect() {
        try {
            csvFileReader.open();
            headers = csvFileReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to open CSV file", e);
        }
    }

    @Override
    public List<Map<String, String>> fetchData() {
        List<Map<String, String>> records = new ArrayList<>();
        try {
            List<String> line;
            while ((line = csvFileReader.readLine()) != null) {
                Map<String, String> record = new HashMap<>();
                for (int i = 0; i < headers.size(); i++) {
                    record.put(headers.get(i), line.size() > i ? line.get(i) : null);
                }
                records.add(record);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV data", e);
        }
        return records;
    }

    @Override
    public void disconnect() {
        try {
            csvFileReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to close CSV file", e);
        }
    }
}
