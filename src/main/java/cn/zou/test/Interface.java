package cn.zou.test;

public interface Interface extends Interface2, Interface3 {
    public static final int a=1;
    int b=1;
    //protected int c=1;

    public abstract void setA();
    void setB();
    //protected abstract void setC();
}
