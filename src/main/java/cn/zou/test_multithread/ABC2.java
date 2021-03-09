package cn.zou.test_multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ABC2 {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            pool.submit(()->{
                System.out.print("A ");
            });
            pool.submit(()->{
                System.out.print("B ");
            });
            pool.submit(()->{
                System.out.println('C');
            });
        }
        pool.shutdown();
    }
}
