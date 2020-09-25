package cn.zou.test;

public abstract class Abstract {
    public static int a;
    final int b=0;

    protected abstract void setA();
    //abstract int setA();
    abstract void setA(int a);

    abstract void setB();

    public Abstract(){

    }
}
