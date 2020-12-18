package cn.zou.test_serializable;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            Person p = new Person("zwh", 22);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            oos.writeObject(p);
            p.setName("zzzz");
            oos.writeObject(p);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
            Person pp = (Person) ois.readObject();
            Person pp2 = (Person) ois.readObject();
            System.out.println(p.getName());
            System.out.println(pp.getName());
            System.out.println(pp2.getName());
            System.out.println(pp == pp2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
