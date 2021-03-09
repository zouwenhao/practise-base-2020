package cn.zou.test_serializable;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            Person p = new Person("zwh", 22, 65.1);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            oos.writeObject(p);
            p.setName("zzzz");
            oos.writeObject(p);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
            Person pp = (Person) ois.readObject();
            Person pp2 = (Person) ois.readObject();
            System.out.println(p);
            System.out.println(pp);
            System.out.println(pp2);
            System.out.println(pp == pp2);

            // Externalizable
            Person2 p2 = new Person2("zwh", 22, 65.1);
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("object2.txt"));
            oos2.writeObject(p2);
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("object2.txt"));
            Person2 ppp = (Person2) ois2.readObject();
            System.out.println(p2);
            System.out.println(ppp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
