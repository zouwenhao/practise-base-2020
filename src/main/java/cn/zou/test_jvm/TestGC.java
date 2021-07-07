package cn.zou.test_jvm;

import org.omg.SendingContext.RunTime;

public class TestGC {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
//        Thread.sleep(1000000);
//        for (int i = 0; i < 102400; i++) {
////            Object o = new int[1024*1024];
////            System.out.println(o);
////        }
        int[] nums = new int[1024];
        System.out.println(nums);
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());

    }
}
