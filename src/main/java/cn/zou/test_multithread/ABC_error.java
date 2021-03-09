package cn.zou.test_multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC_error {

    private int state = 1;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (state!=1) {
                a.await();
            }
            state = 2;
            b.signal();
            print(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (state!=2) {
                b.await();
            }
            state = 3;
            c.signal();
            print(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (state!=3) {
                c.await();
            }
            state = 1;
            a.signal();
            print(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println("线程" + Thread.currentThread() + ", " + i);
        }
    }

    public static void main(String[] args) {
        ABC_error abc = new ABC_error();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                abc.printA();
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                abc.printB();
            }
        };
        Thread threadC = new Thread() {
            @Override
            public void run() {
                abc.printC();
            }
        };
        // 有问题
        for (int i = 0; i < 10; i++) {
            synchronized (abc) {
                threadA.start();
                threadB.start();
                threadC.start();
            }

        }
    }
}
