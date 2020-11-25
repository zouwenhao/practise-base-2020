package cn.zou.test_design_mode.singleton;

public enum SingleTon7_enum {
    instance;

    private SingleTon7_enum() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                // 无法起到多线程竞争作用
                try {
                    Thread.sleep((int)(100*Math.random()));
                    System.out.println(SingleTon7_enum.instance.hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
