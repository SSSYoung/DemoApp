package Algo.dongtaiguihua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kotlin.Pair;
import kotlin.ParameterName;

/**
 * @ProjectName: DemoApp
 * @Desc:
 * @Author: YangShuang
 * @Date: 2023/12/28
 */
class Pinyin {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("请输入汉语拼音字符串：");
        // String pinyin = scanner.nextLine().toLowerCase(); // 将输入的拼音字符串转换为小写
        //
        // String[] initials = {"b", "p", "m", "f", "d", "t", "n", "l", "g", "k", "h", "j", "q", "x", "zh", "ch", "sh", "r", "z", "c", "s", "y", "w"};
        // String[] finals = {"a", "o", "e", "i", "u", "v", "ai", "ei", "ui", "ao", "ou", "iu", "ie", "ue", "er", "an", "en", "in", "un", "ang", "eng", "ing", "ong"};
        //
        // String initial = "";
        // String finalStr = "";
        //
        // for (String i : initials) {
        //     if (pinyin.startsWith(i)) {
        //         initial = i;
        //         pinyin = pinyin.substring(i.length());
        //         break;
        //     }
        // }
        //
        // for (String f : finals) {
        //     if (pinyin.endsWith(f)) {
        //         finalStr = f;
        //         break;
        //     }
        // }
        //
        // System.out.println("声母：" + initial);
        // System.out.println("韵母：" + finalStr);
        Pair<String, String> yang = splitPinyin("shuang");
        System.out.println("声母：" + yang.getFirst() + "------------韵母: " + yang.getSecond());
    }

    private static Pair<String, String> splitPinyin(String pinyin) {
        String[] initials = {"b", "p", "m", "f", "d", "t", "n", "l", "g", "k", "h", "j", "q", "x", "zh", "ch", "sh", "r", "z", "c", "s", "y", "w"};
        String[] finals = {"a", "o", "e", "i", "u", "v", "ai", "ei", "ui", "ao", "ou", "iu", "ie", "ue", "er", "an", "en", "in", "un", "ang", "eng", "ing", "ong"};
        ArrayList<List<String>> lists = new ArrayList<>(10);
        String initial = "";
        String finalStr = "";

        for (String i : initials) {
            if (pinyin.startsWith(i)) {
                initial = i;
                pinyin = pinyin.substring(i.length());
                break;
            }
        }

        for (String f : finals) {
            if (pinyin.endsWith(f)) {
                finalStr = f;
                break;
            }
        }

        return new Pair<>(initial, finalStr);
    }
}
