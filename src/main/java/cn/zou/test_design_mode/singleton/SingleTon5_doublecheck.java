package cn.zou.test_design_mode.singleton;

public class SingleTon5_doublecheck {
    public static SingleTon5_doublecheck instance;

    public static SingleTon5_doublecheck getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingleTon5_doublecheck.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingleTon5_doublecheck();
                }
            }
        }
        return instance;
    }

    private SingleTon5_doublecheck() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                // 无法起到多线程竞争作用
//                try {
//                    Thread.sleep(100);
//                    System.out.println(SingleTon5_doublecheck.getInstance().hashCode());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(SingleTon5_doublecheck.getInstance().hashCode());
            }).start();
        }
    }
}
