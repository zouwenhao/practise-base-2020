package cn.zou.test_jvm;

import java.lang.reflect.Method;

public class TestClass {

    public static void main(String[] args) {
        // 1
        try {
            Class.forName("cn.zou.test_jvm.TestClassObj");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2
        TestClassObj testClassObj = new TestClassObj();
        Class<? extends TestClassObj> obj = testClassObj.getClass();
        Method[] declaredMethods = obj.getDeclaredMethods();
        obj.getDeclaredFields();
        obj.getDeclaredConstructors();
        for (Method method : declaredMethods) {
            System.out.println(method.getName() + " ," + method.getParameterCount());
        }

        // 3
        Class<TestClassObj> objClass = TestClassObj.class;
    }
}
