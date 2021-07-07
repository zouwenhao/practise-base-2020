package cn.zou.leetcode.type_numsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。（只包含加减乘除、数字、空格）
 *
 * 整数除法仅保留整数部分。
 */
public class T227Calculate {

    public static void main(String[] args) {
        T227Calculate t227Calculate = new T227Calculate();
        System.out.println(t227Calculate.calculate("3+2*2"));
        System.out.println(t227Calculate.calculate(" 3+5 / 2 "));
        System.out.println(t227Calculate.calculate(" 3/2 "));
        System.out.println(t227Calculate.calculate("0-0"));
        System.out.println(t227Calculate.calculate("1*1"));
        System.out.println(t227Calculate.calculate("1*1 + 3"));
    }

    /**
     * 思路：
     * 数据结构：两个集合，分别存放做加减的数字和加减字符；一个乘除标记；一个记录当前完整的数字
     * 1.遍历所有字符
     *  如果是乘除就存入到乘除标记中；
     *  如果是数字
     *      如果乘除标记不为空，就取出数组集合最后一个与当前数字进行计算并替换到最后一个；否则只是添加到数字集合中。两种情况都重置当前数字
     *  如果是加减，就存入到加减集合中
     *  如果是空格，跳过
     * 2.用数字集合的第一个数字初始化返回结果，再对剩余的加减集合和数字集合遍历计算返回结果
     * 时间复杂度：O(n)
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.equals(" ")) {
            return 0;
        }
        int result = 0;
        char[] chars = s.toCharArray();
        List<Integer> nums = new ArrayList<>();
        List<Character> cals = new ArrayList<>();
//        Stack<Character> mulDivide = new Stack<>();
        Character mulDivide = null;
        Integer num = null;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('0' <= c && '9' >= c) {
                if (num == null) { // 用于符号转变成数字时的初始化
                    num = 0;
                }
                num = num * 10 + c - '0';
                if (i == chars.length - 1) { // 因为数字的添加操作在字符时，所以注意对最后一个数字的处理
                    if (mulDivide != null) {
                        if ('*' == mulDivide) {
                            nums.set(nums.size() - 1, nums.get(nums.size() - 1) * num);
                        } else {
                            nums.set(nums.size() - 1, nums.get(nums.size() - 1) / num);
                        }
                        mulDivide = null; // 注意重置乘除标志
                    } else {
                        nums.add(num);
                    }
                }

            } else {
                if (num != null) {
                    if (mulDivide != null) {
                        if ('*' == mulDivide) {
                            nums.set(nums.size() - 1, nums.get(nums.size() - 1) * num);
                        } else {
                            nums.set(nums.size() - 1, nums.get(nums.size() - 1) / num);
                        }
                        mulDivide = null;
                        num = null; // 重置被乘除数，防止重复添加到nums中，计算对象错位
                    } else {
                        nums.add(num);
                        num = null;
                    }
                }
                if ('*' == c || '/' == c) {
                    mulDivide = c;
                } else if ('+' == c || '-' == c) {
                    cals.add(c);
                } else {
                    continue;
                }
            }
        }
        result = nums.get(0);
        for (int i = 0; i < cals.size(); i++) {
            Character c = cals.get(i);
            if ('+' == c) {
                result += nums.get(i + 1);
            } else {
                result -= nums.get(i + 1);
            }
        }
        return result;
    }
}
