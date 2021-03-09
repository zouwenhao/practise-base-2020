package cn.zou.test_multithread;

import javafx.concurrent.Task;

import java.util.concurrent.*;

public class Test extends Thread {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("123");
        test.start();
        Runnable runnable = () -> {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (test) {
                System.out.println("notify");
                test.notify();
            }
        };
        runnable.run();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 1000,
                TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>());
        Future<?> submit = threadPoolExecutor.submit(() -> {
            System.out.println(1);
        });
        //Task task = new Task();
        //FutureTask<Object> futureTask = new FutureTask<Object>(task); //不行
    }

    public void print() {
        System.out.println("Done");
    }

    @Override
    public void run() {
        super.run();
        try {
            sleep(1000);
            synchronized (this) {
                System.out.println(this);
                System.out.println("start wait");
                wait();
                System.out.println("wait done");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print();
    }
}
