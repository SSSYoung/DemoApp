package Algo.dongtaiguihua;

class BM63 {
   /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    *
    *
    * @param number int整型
    * @return int整型
    */
   public int jumpFloor (int number) {
      // write code here
      // if (number == 1) {
      //    return 1;
      // }else if (number == 2) {
      //    return 2;
      // } else {
      //    return jumpFloor(number - 1) + jumpFloor(number - 2);
      // }
      if (number == 1) {
         return 1;
      } else if (number == 2) {
         return 2;
      } else {
         int prepre = 1;
         int pre = 2;
         int cur = 0;
         for (int i = 3; i <= number; i++) {
            cur = prepre + pre;
            prepre = pre;
            pre = cur;
         }

         return cur;
      }
   }
}
