package test;

/**
 * 0   1 -1 1 1
 * -1 -1 0 1 -1
 * -1  0 -1 -1 0
 */

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * aaffccdda
 */
public class Main {

    public boolean isClean(String str) {
        if (str == null || str.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0)); //TODO
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.size() != 0 && stack.get(0) == c) stack.pop();
            else stack.push(c);
        }
        if (stack.size() == 0) return true; //TODO
        else return false;
    }
}
