package cn.zou.leetcode.type_string;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 *
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * 注意:
 *
 *     字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T680ValidPalindrome {

    public static void main(String[] args) {
        T680ValidPalindrome t680ValidPalindrome = new T680ValidPalindrome();
        System.out.println(t680ValidPalindrome.validPalindrome("abcdfeefedcba"));
        System.out.println(t680ValidPalindrome.validPalindrome(""));
        System.out.println(t680ValidPalindrome.validPalindrome(null));
        System.out.println(t680ValidPalindrome.validPalindrome("a"));
        System.out.println(t680ValidPalindrome.validPalindrome("aa"));
        System.out.println(t680ValidPalindrome.validPalindrome("aaa"));
        System.out.println(t680ValidPalindrome.validPalindrome("aba"));
        System.out.println(t680ValidPalindrome.validPalindrome("abba"));
        System.out.println(t680ValidPalindrome.validPalindrome("abcba"));
        System.out.println(t680ValidPalindrome.validPalindrome("abceeba"));
        System.out.println(t680ValidPalindrome.validPalindrome("abceeeba"));
        System.out.println(t680ValidPalindrome.validPalindrome("abceeeeba"));
        System.out.println(t680ValidPalindrome.validPalindrome("abca"));
        System.out.println(t680ValidPalindrome.validPalindrome("cbbcc"));
    }

    /**
     * 双指针（AC）
     * 思路：
     * 1.分别为字符串的首尾设置一个索引A、B
     * 2.当左索引A小于等于右索引B时，判断两索引元素
     * 1).当两元素相等时，向内移动索引A、B
     * 2).当两元素不相等时，判断自索引A+1到B的子串是否是回文串，若是则返回true，
     *      否则判断自索引A到B-1的子串是否是回文串，若是则返回true，
     *      否则返回false
     * 3).回文判断成功，返回true
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s){
        if (s == null || s.equals("")) {
            return false;
        }
        int a = 0, b = s.length() - 1;
        while (a <= b) {
            char x = s.charAt(a);
            char y = s.charAt(b);
            if (x == y) {
                a++;
                b--;
            } else return isPalindrome(s, a+1, b) || isPalindrome(s, a, b-1);
//            } else if(isPalindrome(s.substring(a + 1, b + 1))) {    //substring(start, end) : [start,end)
//                return true;
//            } else if (isPalindrome(s.substring(a, b))) {
//                return true;
//            } else return false;

        }
        return true;
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }



    /**
     * 双指针（NG）
     * 思路：
     * 1.分别为字符串的首尾设置一个索引A、B
     * 2.当左索引A小于等于右索引B时，判断两索引元素
     * 1).当两元素相等时，向内移动索引A、B
     * 2).当两元素不相等时，判断索引A+1和B以及A+2和B-1是否相等，若相等则返回true，否则
     *      判断索引A和B-1以及A+1和B-2是否相等，若相等则返回true，否则返回false
     *
     * @param s
     * @return
     */
    public boolean validPalindrome_error(String s){
       if (s == null || s.equals("")) {
           return false;
       }
       int a = 0, b = s.length() - 1;
       int count = 0;
       while (a <= b) {
           char x = s.charAt(a);
           char y = s.charAt(b);
           if (x == y) {
               a++;
               b--;
           } else if (count == 0 && (b - 1) >= a && x == s.charAt(b - 1)) {
               if ((b - 1) == a) return true;
               if ((a + 1) < b && (b - 2) > a && s.charAt(a + 1) == s.charAt(b - 2)) {
                   a+=1;
                   b-=2;
                   count++;
               }
           } else if (count == 0 && (a + 1) <= b && y == s.charAt(a + 1)) {
               if ((a + 1) == b) return true;
               if ((a + 1) < b && (b - 1) > a && s.charAt(a + 2) == s.charAt(b - 1)) {
                   a+=2;
                   b-=1;
                   count++;
               }
           } else return false;
       }
       return true;
    }
}
