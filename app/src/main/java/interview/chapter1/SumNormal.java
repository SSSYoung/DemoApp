package interview.chapter1;

public class SumNormal {
   public static void main(String[] args) {
      int count = 0;
      int[] src = MakeArray.makeArray();

      long pre = System.currentTimeMillis();

      for (int i = 0; i < src.length; i++) {
         count += src[i];
      }

      System.out.println("count====" + count + ", cost time====" + (System.currentTimeMillis() - pre));
   }
}
