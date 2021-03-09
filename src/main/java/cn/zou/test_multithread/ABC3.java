package cn.zou.test_multithread;

public class ABC3 {

    public static void main(String[] args) {
        Param param = new Param();
        new Thread(new Print(param, 0, "A")).start();
        new Thread(new Print(param, 1, "B")).start();
        new Thread(new Print(param, 2, "C")).start();
    }
}

class Print implements Runnable {

    private Param param;
    private int state;
    private String content;

    public Print(Param param, int state, String content) {
        this.param = param;
        this.state = state;
        this.content = content;
    }

    @Override
    public void run() {
        synchronized (param) {
            for (int i = 1; i <= 10; i++) {
                int flag = param.getState();
                while (flag != state) { // 自旋获取当前标志
                    try {
                        param.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = param.getState(); // 重新获取当前标志
                }
                System.out.println(content);
                param.setState(++flag % 3); // 通过标志位控制执行顺序
                param.notifyAll();
            }
        }
    }
}

class Param {

    private int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
