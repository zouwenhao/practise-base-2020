package cn.zou.test_multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapUnsafe {

    public static void main(String[] args) {
        Thread t1 = new HashMapThread();
        Thread t2 = new HashMapThread();
        Thread t3 = new HashMapThread();
        Thread t4 = new HashMapThread();
        Thread t5 = new HashMapThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class HashMapThread extends Thread {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static AtomicInteger ai = new AtomicInteger();

    @Override
    public void run() {
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }
}
