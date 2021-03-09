package test;

import java.util.Scanner;

/**
 * *as*as*s*
 * ***asasss
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(moveChar(s));
        }
    }

    public static String moveChar(String str) {
        if (str == null) return "";
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '*') builder.append('*');
            else temp.append(c);
        }
        return builder.append(temp).toString();
    }
}
