package cn.zou.leetcode.type2_reverse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 *
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 *
 *
 * 提示：
 *
 *     元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T345ReverseVowels {

    public static void main(String[] args) {
        T345ReverseVowels t345ReverseVowels = new T345ReverseVowels();
        System.out.println(t345ReverseVowels.reverseVowels(""));
        System.out.println(t345ReverseVowels.reverseVowels("a"));
        System.out.println(t345ReverseVowels.reverseVowels("aaadeee"));
        System.out.println(t345ReverseVowels.reverseVowels("aaadee"));
        System.out.println(t345ReverseVowels.reverseVowels("aaaaa"));
        System.out.println(t345ReverseVowels.reverseVowels("ooooo"));
        System.out.println(t345ReverseVowels.reverseVowels("aeiou"));
        System.out.println(t345ReverseVowels.reverseVowels("wqdcsdzfeasdeu"));
        System.out.println(t345ReverseVowels.reverseVowels("hello"));
        System.out.println(t345ReverseVowels.reverseVowels("leetcode"));
        System.out.println(t345ReverseVowels.reverseVowels("aA"));
    }

    public String reverseVowels(String s) {
        if (s==null) return null;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            //while (left < chars.length && !vowels.contains(chars[left])) left++;
            // 增加索引判断：1.防止越界移除 2.剪枝：不用再判断[right,length-1]中的元素
            while (left < right && !vowels.contains(chars[left])) left++;
            //while (right >= 0 && !vowels.contains(chars[right])) right--;
            while (right > left && !vowels.contains(chars[right])) right--;
            //if (left < right && vowels.contains(chars[left]) && vowels.contains(chars[right])) {
            // 不用再判断当前索引是否是元音字母，判断前只可能存在三种情况：
            // 1.两个字母都是元音
            // 2.一个元音字母，另一个索引一直因为一直不是元音导致移动到这个元音位置
            // 3.两个非元音字母，right比left大
            if (left < right) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
