package cn.zou.test_yinyong;

import java.lang.ref.WeakReference;

public class Main {

    public static void main(String[] args) {
//        Object obj = new Object();
//        SoftReference<Object> softReference = new SoftReference<Object>(obj);
//        obj = null;
//        byte[] bytes = new byte[30 * 1024 * 1024];
//        for (int i = 0; i < bytes.length; i++) {
//            bytes[i] = 1;
//        }
//        System.out.println(Runtime.getRuntime().maxMemory());
//        System.out.println(Runtime.getRuntime().freeMemory());
//        System.out.println(Runtime.getRuntime().totalMemory());
//        System.gc();
//        //未试验出
//        System.out.println("软引用对象：" + softReference.get());

        Object obj2 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj2);
        //obj2 = null
        obj2 = new Object();
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());

    }
}
