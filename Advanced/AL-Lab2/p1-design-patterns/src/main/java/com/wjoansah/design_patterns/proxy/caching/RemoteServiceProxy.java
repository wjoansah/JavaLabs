package com.wjoansah.design_patterns.proxy.caching;

import java.util.HashMap;
import java.util.Map;

public class RemoteServiceProxy implements RemoteService {
    private final RemoteService remoteService;
    private final Map<String, String> cache = new HashMap<>();

    public RemoteServiceProxy(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @Override
    public String fetchData(String key) {
        if (cache.containsKey(key)) {
            System.out.println("Cache hit for key: " + key);
            return cache.get(key);
        }

        System.out.println("Cache miss for key: " + key);
        String data = remoteService.fetchData(key);
        cache.put(key, data);

        return data;
    }
}
