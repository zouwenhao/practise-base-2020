package cn.zou.leetcode.type_string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T125IsPalindrome {

    public static void main(String[] args) {
        System.out.println((int)'0');
        System.out.println((int)'a');
        System.out.println((int)'A');
        T125IsPalindrome t125IsPalindrome = new T125IsPalindrome();
        System.out.println(t125IsPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * 验证是否是指定规则的回文串
     * 双指针（AC）
     * 思路：
     * 1.分别为字符串首位设置索引A、B
     * 2.A<=B时，判断字符：
     * 1).若两字符非指定字符，移动对应索引跳过当前字符进入下次判断
     * 2).当两字符都是指定范围时，同时转换成大写或小写后判断是否相等，若不相等直接返回false
     * 3.索引迭代完成，返回true
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        if (s == null) return false;
        int a = 0, b = s.length() - 1;
        while (a <= b) {
            char x = s.charAt(a);
            // 如果当前字符非数字、大小写字符，则忽略该字符
            if (!((x >= 97 && x <= 122) || (x >= 48 && x<=57) || (x >= 65 && x <= 90))) {
                a++;
                continue;
            }
            char y = s.charAt(b);
            if (!((y >= 97 && y <= 122) || (y >= 48 && y<=57) || (y >= 65 && y <= 90))) {
                b--;
                continue;
            }
            // 对于字母，将两个字符都转换成小写进行判断
            if (s.charAt(a) == s.charAt(b) || Character.toLowerCase(s.charAt(a)) == Character.toLowerCase(s.charAt(b))) {
                a++;
                b--;
            } else return false;
        }
        return true;
    }
}
