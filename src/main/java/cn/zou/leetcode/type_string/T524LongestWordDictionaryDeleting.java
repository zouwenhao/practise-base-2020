package cn.zou.leetcode.type_string;


import java.util.*;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 *
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出:
 * "apple"
 *
 * 示例 2:
 *
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * 输出:
 * "a"
 *
 * 说明:
 *
 *     所有输入的字符串只包含小写字母。
 *     字典的大小不会超过 1000。
 *     所有输入的字符串长度不会超过 1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T524LongestWordDictionaryDeleting {

    /**
     * NC
     * @param s
     * @param d
     * @return
     * @throws RuntimeException
     */
    public String findLongestWord_v1(String s, List<String> d) {
        if (s == null || s.equals("") || d == null || d.size() == 0) {
            return "";
        }
        List<String> targets = new ArrayList();
        // 添加所有子串
        for (int i = 0; i < d.size(); i++) {
            StringBuilder subStr = new StringBuilder(s);
            String target = d.get(i);
            //从末尾开始判断字符串（未NC）
//            int j = target.length() - 1;
//            int subEnd = 0;
//            while (j > -1 && (subEnd = subStr.lastIndexOf(String.valueOf(target.charAt(j--)))) > -1) {
//                // 从末尾删除效率会高？
//                subStr = subStr.delete(subEnd, subStr.length());
//            }
//            if (j == -1) {
//                targets.add(target);
//            }
            int j = 0, subStart;
            while (j < target.length()) {
                String c = String.valueOf(target.charAt(j++));
                subStart = subStr.indexOf(c);
                if (subStart > -1) {
                    subStr = subStr.delete(0, subStart + 1);
                } else {
                    break;
                }
            }
            if (j == target.length()) {
                targets.add(target);
            }
        }
        // 找出最长子串时，同时保留原字典顺序，返回字典最先出现的最长子串
//        int max = 0;
//        List<String> targets = new ArrayList<>();
//        for (String target: targetsTemp) {
//            if (target.length() > max) {
//                max = target.length();
//                targets.clear();
//            }
//            targets.add(target);
//        }
        // 对所有子串进行降序排序（不保留原字典顺序）
        Collections.sort(targets, (item1, item2) -> {
            // 子串长度不同时，降序
            if (item2.length() > item1.length()) {
                return 1;
            } else if (item2.length() < item1.length()) {
                return -1;
            } else {
                // 子串长度相同时，升序
                return item1.compareTo(item2);
            }
        });
        return targets.size() == 0 ? "" : targets.get(0);
    }

    /**
     * NC
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        List<String> words = new ArrayList<>();
        // 遍历集合，找出所有的子串并记录下来
        for (int i = 0; i < d.size(); i ++) {
            if (isSubStr(s, d.get(i))) words.add(d.get(i));
        }
        // 对所有找到的子串进行排序（1. 按照长度递减；2. 长度相等时，按照字符的ASCII递增）
        sortCollection(words);
        return words.size() ==  0 ? "" : words.get(0);
    }

    public void sortCollection(List<String> words) {
        Collections.sort(words, (o1, o2) -> {
            if (o1.length() < o2.length()) return 1;
            else if (o1.length() > o2.length()) return -1;
            else return o1.compareTo(o2);
        });
    }

    public boolean isSubStr(String s, String t) {
        int sLeft = 0, sRight = s.length() - 1; //检索指针
        int tLeft = 0, tRight = t.length() - 1; //判断指针
        // 当检索指针越界时，不是子串
        String str = "abpcplea";
        List<String> dic = Arrays.asList(new String[]{"ale","apple","monkey","plea", "abple", "apcle"});
        while (sLeft <= sRight) {
            if (s.charAt(sLeft) == t.charAt(tLeft)) {
                sLeft ++;
                tLeft ++;
            } else {
                sLeft ++;
                continue;
            }
            if (s.charAt(sRight) == t.charAt(tRight)) {
                sRight --;
                tRight --;
            } else {
                sRight --;
                continue;
            }
            // tLeft == tRight + 1： 当出现诸如检索字符串中最后判断的子串是"ab"，而目标字符串最后被判断的也是"ab"，
            //   这样最后的两个子串都相等时，判断指针会出现右指针被移动到了左指针左边
            // tLeft == tRight： 当最后的判断子串是两位字符，而检索子串是两位字符以上，且倒数第二位字符不相等时，如"abca"和"aa"
            if (tLeft >= tRight) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        T524LongestWordDictionaryDeleting t524 = new T524LongestWordDictionaryDeleting();
        String str = "abpcplea";
        List<String> dic = Arrays.asList(new String[]{"ale","apple","monkey","plea", "abple", "apcle"});
        System.out.println(t524.findLongestWord(str, dic));
        String str2 = "abpcplea";
        List<String> dic2 = Arrays.asList(new String[]{"a","b","c"});
        System.out.println(t524.findLongestWord(str2, dic2));
        String str3 = "bab";
        List<String> dic3 = Arrays.asList(new String[]{"ba","ab","a","b"});
        System.out.println(t524.findLongestWord(str3, dic3));
        String str4 = "apple";
        List<String> dic4 = Arrays.asList(new String[]{"zxc","vbn"});
        System.out.println(t524.findLongestWord(str4, dic4));
        String str5 = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
        List<String> dic5 = Arrays.asList(new String[]{"rjufvjafbxnbgriwgokdgqdqewn","ntgcykxhdfescxxypyew"});
        System.out.println(t524.findLongestWord(str5, dic5));
        String str6 = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
        List<String> dic6 = Arrays.asList(new String[]{"ettphsiunoglotjlccurlre","ntgcykxhdfescxxypyew"});
        System.out.println(t524.findLongestWord(str6, dic6));
    }

}
