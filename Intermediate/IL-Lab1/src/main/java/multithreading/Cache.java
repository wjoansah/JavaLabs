package multithreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Cache<K, V> {
    private final ConcurrentMap<K, V> cache;
    private int size;

    public Cache() {
        this.cache = new ConcurrentHashMap<K, V>();
    }

    public void put(K key, V value) {
        cache.put(key, value);
        size++;
    }
    public V get(K key) {
        return cache.get(key);
    }

    public void update(K key, V value) {
        cache.put(key, value);
    }

    public void clear() {
        cache.clear();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

    }
}
