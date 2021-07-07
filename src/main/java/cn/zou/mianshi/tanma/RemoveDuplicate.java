package cn.zou.mianshi.tanma;

import java.util.*;

/**
 * 每个字符串中包含一个数字子串和多个字母子串，若字符串包含的数字子串是一样的，则认为这两个字符串是相等的
 * 对字符串集合去重
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        List<String> list = Arrays.asList("123abc", "abc1234", "a123b", "a12335b", "aawss12345");
        List<String> removedList = removeDuplicate.remove(list);
        removedList.forEach(System.out::println);
    }

    public List<String> remove(List<String> list) {
        List<String> removedList = new ArrayList<>();
        Set<String> numSet = new HashSet<>();
        for (String str : list) {
            int numStart = -1, numEnd = -1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    numStart = numStart == -1 ? i : numStart;
                    numEnd = i;
                } else if (numStart > -1) break;
            }
            String num = str.substring(numStart, numEnd + 1);
            if (!numSet.contains(num)) {
                removedList.add(str);
                numSet.add(num);
            }
        }
        return removedList;
    }

}
