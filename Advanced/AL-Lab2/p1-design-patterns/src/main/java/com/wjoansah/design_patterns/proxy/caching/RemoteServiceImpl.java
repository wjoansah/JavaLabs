package com.wjoansah.design_patterns.proxy.caching;

public class RemoteServiceImpl implements RemoteService {
    @Override
    public String fetchData(String key) {
        System.out.println("Fetching data from the remote service with key: " + key);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data for key: " + key;
    }
}
