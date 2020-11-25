package cn.zou.test_design_mode.singleton;

public class SingleTon1_hungry {
    public static final SingleTon1_hungry instance = new SingleTon1_hungry();

    private SingleTon1_hungry() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                    System.out.println(SingleTon1_hungry.instance);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
