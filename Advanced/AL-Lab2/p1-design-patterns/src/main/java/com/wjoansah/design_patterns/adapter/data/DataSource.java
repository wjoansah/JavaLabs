package com.wjoansah.design_patterns.adapter.data;

import java.util.List;
import java.util.Map;

public interface DataSource {
    void connect();

    List<Map<String, String>> fetchData();

    void disconnect();
}
