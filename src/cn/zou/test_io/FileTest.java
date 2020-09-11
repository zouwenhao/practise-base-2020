package cn.zou.test_io;

import java.io.*;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("/home/zouwh/IdeaProjects/Restudy/Restudy.iml");

        printFile(file);
    }

    public static void copyFile(File source, File target) {
        try {
            InputStream in = new FileInputStream(source);
            byte[] bytes = new byte[1024];
            while (in.read(bytes, 0, bytes.length) != -1) {
                System.out.printf("");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFile(File file) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
