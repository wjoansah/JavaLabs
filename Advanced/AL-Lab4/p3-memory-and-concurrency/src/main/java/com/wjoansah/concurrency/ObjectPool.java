package com.wjoansah.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool<T> {
    private final BlockingQueue<T> pool;

    public ObjectPool(int size, ObjectFactory<T> factory) {
        pool = new LinkedBlockingQueue<>(size);
        for (int i = 0; i < size; i++) {
            pool.offer(factory.create());
        }
    }

    public T borrowObject() throws InterruptedException {
        return pool.take();
    }

    public void returnObject(T object) {
        pool.offer(object);
    }

    public interface ObjectFactory<T> {
        T create();
    }
}
