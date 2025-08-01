package Algo.shuangzhizheng;

class BM88 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        // write code here
        int length = str.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
