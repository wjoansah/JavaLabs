package concurrency;


import java.util.concurrent.ConcurrentHashMap;

public class Cache<K, V> {
    private final ConcurrentHashMap<K, V> cache;

    public Cache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public int size() {
        return cache.size();
    }

    public void clear() {
        cache.clear();
    }

    public static void main(String[] args) {
        var cache = new Cache<String, Object>();

        Thread server1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                cache.put("key" + i, "value" + i);
                System.out.println("Server1 put: key" + i + " -> value" + i);
            }
        });

        Thread server2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                var value = i * i;
                cache.put("key" + i, "value" + value);
                System.out.println("Server2 put: key" + i + " -> value" + value);
            }
        });


        Thread client = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                var value = (String) cache.get("key" + i);
                System.out.println("Reader got: key" + i + " -> " + value);
            }
        });

        server1.start();
        server2.start();
        client.start();

        try {
            server1.join();
            server2.join();
            client.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
