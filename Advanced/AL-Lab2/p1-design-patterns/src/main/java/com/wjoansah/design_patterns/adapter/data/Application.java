package com.wjoansah.design_patterns.adapter.data;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        DataSource dataSource = new CsvDataSourceAdapter("data.csv");

        dataSource.connect();
        List<Map<String, String>> data = dataSource.fetchData();
        dataSource.disconnect();

        // Display the data
        for (Map<String, String> record : data) {
            System.out.println(record);
        }
    }
}
