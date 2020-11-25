package cn.zou.test_design_mode.singleton;

public class SingleTon2_hungry {
    public static final SingleTon2_hungry instance;

    static {
        instance = new SingleTon2_hungry();
    }

    private SingleTon2_hungry() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                    System.out.println(SingleTon2_hungry.instance);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
