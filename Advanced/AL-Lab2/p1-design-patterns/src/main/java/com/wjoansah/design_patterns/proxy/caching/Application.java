package com.wjoansah.design_patterns.proxy.caching;

public class Application {
    public static void main(String[] args) {
        RemoteService service = new RemoteServiceImpl();
        RemoteService serviceProxy = new RemoteServiceProxy(service);

        System.out.println(serviceProxy.fetchData("item1"));

        System.out.println(serviceProxy.fetchData("item1"));

        System.out.println(serviceProxy.fetchData("item2"));
    }

}
