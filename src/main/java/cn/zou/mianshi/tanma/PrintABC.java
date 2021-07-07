package cn.zou.mianshi.tanma;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 顺序打印ABC10次
 */
public class PrintABC {
    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
        printABC.printABC(10);
    }

    public void printABC(int loop) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < loop; i ++) {
            executorService.submit(() -> System.out.println('A'));
            executorService.submit(() -> System.out.println('B'));
            executorService.submit(() -> System.out.println('C'));
        }
        executorService.shutdown();
    }
}
