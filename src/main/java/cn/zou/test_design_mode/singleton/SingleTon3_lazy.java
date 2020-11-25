package cn.zou.test_design_mode.singleton;

public class SingleTon3_lazy {
    public static SingleTon3_lazy instance;

    public static SingleTon3_lazy getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleTon3_lazy();
        }
        return instance;
    }

    private SingleTon3_lazy() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                // 无法起到多线程竞争作用
//                try {
//                    Thread.sleep(100);
//                    System.out.println(SingleTon3_lazy.getInstance().hashCode());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(SingleTon3_lazy.getInstance().hashCode());
            }).start();
        }
    }
}
