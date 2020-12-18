package cn.zou.test_jvm;

public class TestClassObj extends TestClassObjFather {

    static {
        System.out.println("静态1");
        System.out.println("静态1.2 i:" + i);
    }

    public TestClassObj(){
        System.out.println(i);
    }

    private void testPrivate() {}

    static {
        System.out.println("静态2 i:" + i);
        i = 2;
        System.out.println("静态2.2 i:" + i);
    }

    //i = 3;

    public static void main(String[] args) {
        try {
            Class<?> obj = Class.forName("cn.zou.test_jvm.TestClassObj");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        TestClassObj testClassObj = new TestClassObj();
    }
}
