package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: DemoApp
 * @Desc:
 * @Author: YangShuang
 * @Date: 2023/12/18
 */
public class UnitBase {
    public int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        // //手动开启协变  父亲 =   孩子
        // List<? extends Object> list = new ArrayList<String>();
        List<Object> list1 = new ArrayList<Object>();
        List<? super String> list2 = list1;
    }
}
