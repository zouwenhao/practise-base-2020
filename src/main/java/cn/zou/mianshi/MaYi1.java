package cn.zou.mianshi;

public class MaYi1 {

    public static void main(String[] args) {
        MaYi1 maYi1 = new MaYi1();
        System.out.println(maYi1.getMaxSortedSub("a"));
        System.out.println(maYi1.getMaxSortedSub("aada"));
        System.out.println(maYi1.getMaxSortedSub("abc"));
        System.out.println(maYi1.getMaxSortedSub("abcabcsacfgtz"));
    }

    /**
     * 题目2：按字符顺序字符串，称为【有序字符串】，例如：abcd，长度为4；
     * 随机给一串字符串(字符是a~z随机)，长度3000字符以内；
     * 要在随机字符字符串中，找出最长的【有序字符串】；
     * @param str
     * @return
     */
    public String getMaxSortedSub(String str) {
        if (str == null || str.equals("")) return "";
        String sub = "";
        int begin = 0, end = 0, count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) <= str.charAt(i + 1)) {
                count++;
                end = i + 1;
            }
            else {
                // 重置
                begin = i + 1;
                end = begin;
                count = 1;
            }
        }
        if (count > sub.length()) {
            sub = str.substring(begin, end + 1);
        }
        return sub;
    }
}
