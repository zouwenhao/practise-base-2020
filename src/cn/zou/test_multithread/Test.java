package cn.zou.test_multithread;

public class Test extends Thread {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("123");
        test.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (test) {
                    System.out.println("notify");
                    test.notify();
                }
            }
        };
        runnable.run();


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
