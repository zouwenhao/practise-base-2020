package cn.zou.mianshi;

import java.util.Arrays;

public class DaXi {

    public static void main(String[] args) {
        DaXi daXi = new DaXi();
        daXi.print(daXi.merge(new int[0][]));
        daXi.print(daXi.merge(new int[][]{{1,2}}));
        daXi.print(daXi.merge(new int[][]{{1,3},{2,4}}));
        daXi.print(daXi.merge(new int[][]{{1,5},{2,3},{3,4},{6,7}}));
        daXi.print(daXi.merge(new int[][]{{1,5},{2,3},{3,4},{6,7},{8,9}}));

        System.out.println(daXi.valid("abc",""));
        System.out.println(daXi.valid("abc","a"));
        System.out.println(daXi.valid("abc","abc"));
        System.out.println(daXi.valid("abc","1bcd"));
        System.out.println(daXi.valid("abc","2c"));
        System.out.println(daXi.valid("abc","2"));
        System.out.println(daXi.valid("abc","a2"));
        System.out.println(daXi.valid("abc","a1b"));
        System.out.println(daXi.valid("abc","a2c"));
        System.out.println(daXi.valid("abc","3"));
        System.out.println(daXi.valid("abc","4e"));
        System.out.println(daXi.valid("internationalization","i12iz4n"));
        System.out.println(daXi.valid("apple","a2e"));
    }

    // 第三题
    /**
     * 最⼩惩罚
     * 带权重的无向图最短路径
     * @param n
     * @param edges
     * @param start
     * @param end
     * @return
     */
    public int minPath(int n, int[][] edges, int start, int end) {
        return 0;
    }

    // 第二题
    /**
     * 缩写校验
     * 对abbr中的字符处理，移动word的指针来判断
     * @param word
     * @param abbr
     * @return
     */
    public boolean valid(String word, String abbr) {
        if (abbr == null || abbr.equals("") || abbr.length() > word.length()) return false;
        int indexW = 0, length = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c  = abbr.charAt(i);
            if (c >= '0' && c <= '9') { // 计算指针偏移量
                length = length * 10 + c - '0';
            } else {
                indexW+=length;
                length = 0; // 重置偏移量
                if (indexW < word.length() && c == word.charAt(indexW)){ // 确认偏移量在有效范围内
                    indexW++;
                } else {
                    return false;
                }
            }
            if (indexW > word.length()) return false;
        }
        indexW += length;
        // 指针最后等于原字符串长度
        if (indexW != word.length()) return false;
        return true;
    }

    public void print(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i][0] + "," + nums[i][1] + "  ");
        }
        System.out.println();
    }

    // 第一题
    /**
     * 合并时间区间
     * 模拟
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        int[][] merged = new int[intervals.length][2];
        int start = intervals[0][0], end = intervals[0][1]; // 初始化哨兵
        int index = 0, maxIndex = intervals.length - 1;
        // 对前n-1个区间进行 上一时区结束点与下一时区开始点判断，直至连续范围内的最大值来构建
        for (int i = 0; i < maxIndex; i++) {
            if (end >= intervals[i+1][0]) {
                continue;
            } else {
                merged[index][0] = start;
                merged[index][1] = end;
                start = intervals[i+1][0]; // 重置哨兵
                end = intervals[i+1][1];
                index++;
            }
        }
        // 确认哨兵与最后一个区间的关系
        if (end < intervals[maxIndex][0]) {
            merged[index][0] = intervals[maxIndex][0];
            merged[index][1] = intervals[maxIndex][1];
        } else if (end < intervals[maxIndex][1]) {
            merged[index][0] = start;
            merged[index][1] = intervals[maxIndex][1];
        } else {
            merged[index][0] = start;
            merged[index][1] = end;
        }
        return Arrays.copyOfRange(merged, 0, index + 1);
    }


}
