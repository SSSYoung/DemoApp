package Algo.stringalgo;

class BM83_1 {
    public static String solution(String s, int n) {
        if (n == 0) {
            return s;
        }

        //step1:大小写反过来
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c - 'A' + 'a'));
            } else if (c >= 'a' && c <= 'z') {
                sb.append((char) (c - 'a' + 'A'));
            } else {
                sb.append(c);
            }
        }

        System.out.println("翻转大小写后：" + sb.toString());

        //Step2:全部反转
        sb.reverse();
        System.out.println("全部翻转后：" + sb.toString());

        //Step3:反转单个单词
        // int start = 0;
        // int end = 1;
        // while (start < n) {
        //     while (end < n && (sb.charAt(end) != ' ')) {
        //         end++;
        //     }
        //     System.out.println("start: " + start + ", end: " + end);
        //
        //     String substring = sb.substring(start, end);
        //     StringBuilder tmp = new StringBuilder(substring);
        //     sb.replace(start, end, tmp.reverse().toString());
        //     start = end + 1;
        //     end = start + 1;
        // }
       //sb = sb.reverse();
       for (int i = 0; i < n; i++) {
          int j = i;
          //以空格为界，二次翻转
          while (j < n && sb.charAt(j) != ' ') {
             j++;
          }
          String temp = sb.substring(i, j);
          StringBuffer buffer = new StringBuffer(temp);
          temp = buffer.reverse().toString();
          sb.replace(i, j, temp);
          i = j;
       }
       System.out.println("result===" + sb.toString());
       return sb.toString();
    }

    public static void main(String[] args) {
        String test = "Hello World";
        solution(test, test.length());
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public String trans(String s, int n) {
        if (n == 0) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            //大小写转换
            if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                sb.append((char) (s.charAt(i) - 'A' + 'a'));
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append((char) (s.charAt(i) - 'a' + 'A'));
            } else
            //空格直接复制
            {
                sb.append(s.charAt(i));
            }
        }
        //翻转整个字符串
        sb = sb.reverse();
        for (int i = 0; i < n; i++) {
            int j = i;
            //以空格为界，二次翻转
            while (j < n && sb.charAt(j) != ' ') {
                j++;
            }
            String temp = sb.substring(i, j);
            StringBuffer buffer = new StringBuffer(temp);
            temp = buffer.reverse().toString();
            sb.replace(i, j, temp);
            i = j;
        }
        return sb.toString();
    }
}
