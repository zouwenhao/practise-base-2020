package cn.zou.test_design_mode.singleton;

public class SingleTon6_staticinner {
    public static SingleTon6_staticinner instance;

    private static class SingleTon6Holder {
        public static final SingleTon6_staticinner instance = new SingleTon6_staticinner();
    }

    public static SingleTon6_staticinner getInstance() {
        return SingleTon6Holder.instance;
    }

    private SingleTon6_staticinner() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                // 无法起到多线程竞争作用
//                try {
//                    Thread.sleep(100);
//                    System.out.println(SingleTon6_staticinner.getInstance().hashCode());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(SingleTon6_staticinner.getInstance().hashCode());
            }).start();
        }
    }
}
