package Algo.stringalgo;

class BM83 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s      string字符串
     * @param length int整型
     * @return string字符串
     */
    public static String trans(String s, int length) {
        // write code here
        //第一步:去掉首位多余的空格
        StringBuilder sb = removeExtraSpace(s, length);
        //第二步：全部反转
        sb.reverse();
        //第三步：反转单个单词
        reverseEachWord(sb);
        return null;
    }

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int length = sb.length();

        while (start < length) {
            while (end < length && sb.charAt(end) != ' ') {
                end++;
            }

            reverseString(sb, start, end);

            start = end + 1;
            end = start + 1;
        }
    }

    public static void main(String[] args) {
       String test = "the sky is blue ";
       String trans = trans(test, test.length());
       System.out.println(trans);
       // System.out.println(removeSpace(test).toString());
        // // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // // 1.去除首尾以及中间多余空格
        // StringBuilder sb = removeSpace(test);
        // // 2.反转整个字符串
        // reverseString(sb, 0, sb.length() - 1);
        // // 3.反转各个单词
        // reverseEachWord(sb);
    }

    /**
     * 不使用Java内置方法实现
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    // public static String reverseWords(String s) {
    //    // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
    //    // 1.去除首尾以及中间多余空格
    //    StringBuilder sb = removeSpace(s);
    //    // 2.反转整个字符串
    //    reverseString(sb, 0, sb.length() - 1);
    //    // 3.反转各个单词
    //    reverseEachWord(sb);
    //    return sb.toString();
    // }
    //

    private static StringBuilder removeExtraSpace(String s, int length) {
           int start = 0;
           int end = length - 1;
           while (s.charAt(start) == ' ') start++;
           while (s.charAt(end) == ' ') end--;
           StringBuilder sb = new StringBuilder();
           while (start <= end) {
              char c = s.charAt(start);
              if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                 sb.append(c);
              }
              start++;
           }
           // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
           return sb;
        // int start = 0;
        // int end = length - 1;
        //
        // while (s.charAt(start) != ' ') {
        //     start++;
        // }
        //
        // while (s.charAt(end) != ' ') {
        //     end--;
        // }
        //
        // StringBuilder sb = new StringBuilder();
        // while (start <= end) {
        //     char c = s.charAt(start);
        //
        //     if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
        //         sb.append(c);
        //     }
        //
        //     start++;
        // }
        //
        // return sb;
    }
    // private static StringBuilder removeSpace(String s) {
    //    // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
    //    int start = 0;
    //    int end = s.length() - 1;
    //    while (s.charAt(start) == ' ') start++;
    //    while (s.charAt(end) == ' ') end--;
    //    StringBuilder sb = new StringBuilder();
    //    while (start <= end) {
    //       char c = s.charAt(start);
    //       if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
    //          sb.append(c);
    //       }
    //       start++;
    //    }
    //    // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
    //    return sb;
    // }
    //

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    //
    // private static void reverseEachWord(StringBuilder sb) {
    //    int start = 0;
    //    int end = 1;
    //    int n = sb.length();
    //    while (start < n) {
    //       while (end < n && sb.charAt(end) != ' ') {
    //          end++;
    //       }
    //       reverseString(sb, start, end - 1);
    //       start = end + 1;
    //       end = start + 1;
    //    }
    // }
    public static void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }
}
