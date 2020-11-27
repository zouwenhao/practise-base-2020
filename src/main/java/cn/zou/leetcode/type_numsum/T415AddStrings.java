package cn.zou.leetcode.type_numsum;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 *
 * 提示：
 *
 *     num1 和num2 的长度都小于 5100
 *     num1 和num2 都只包含数字 0-9
 *     num1 和num2 都不包含任何前导零
 *     你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T415AddStrings {

    public static void main(String[] args) {
        T415AddStrings t415AddStrings = new T415AddStrings();
        System.out.println(t415AddStrings.addStrings("", ""));
        System.out.println(t415AddStrings.addStrings("1", ""));
        System.out.println(t415AddStrings.addStrings("", "1"));
        System.out.println(t415AddStrings.addStrings("0", "0"));
        System.out.println(t415AddStrings.addStrings("12", "0"));
        System.out.println(t415AddStrings.addStrings("12", "999"));
    }

    /**
     * 模拟：对两数依次对低位进行求和，保留商和进位
     *
     * 核心：分别对两个字符串末尾初始化指针，进行求和计算，保留进位。
     * 1. 当两指针中，只要还在字符串长度范围内，或者进位不为0时， 就进行计算及两指针移位
     * 2. 取两字符串每位数字时，需要判断指针范围是否有效，否则将该位数字置为0
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int pos1 = num1.length() - 1, pos2 = num2.length() -1, add = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (pos1 >= 0 || pos2 >= 0 || add != 0) {
            int x = pos1 >= 0 ? num1.charAt(pos1) - '0' : 0;
            int y = pos2 >= 0 ? num2.charAt(pos2) - '0' : 0;
            stringBuffer.append((x + y + add) % 10);
            add = (x + y + add) / 10;
            pos1--;
            pos2--;
        }
        return stringBuffer.reverse().toString();
    }
}
