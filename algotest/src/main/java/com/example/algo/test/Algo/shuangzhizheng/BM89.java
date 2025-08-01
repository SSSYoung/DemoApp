package com.example.algo.test.Algo.shuangzhizheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class BM89 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */

    /**
     * step1：按左边界排序
     * step2:每次和最后一个合并
     * @param intervals
     * @return
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }
        // write code here
        //step1：按左边界排序
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        //放入第一个
        ArrayList<Interval> rst = new ArrayList<Interval>();
        rst.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval last = rst.get(rst.size() - 1);

            // 没有相交
            if (intervals.get(i).start > last.end) {
                rst.add(intervals.get(i));
            } else {
                //相交了
                last.end = Math.max(last.end, intervals.get(i).end);
            }
        }

        return rst;
    }

    public static void main(String[] args) {

    }

    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
