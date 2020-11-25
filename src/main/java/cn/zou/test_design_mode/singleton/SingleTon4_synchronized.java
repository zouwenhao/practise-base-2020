package cn.zou.test_design_mode.singleton;

public class SingleTon4_synchronized {
    public static SingleTon4_synchronized instance;

    public static synchronized SingleTon4_synchronized getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleTon4_synchronized();
        }
        return instance;
    }

    private SingleTon4_synchronized() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                // 无法起到多线程竞争作用
//                try {
//                    Thread.sleep(100);
//                    System.out.println(SingleTon4_synchronized.getInstance().hashCode());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(SingleTon4_synchronized.getInstance().hashCode());
            }).start();
        }
    }
}
