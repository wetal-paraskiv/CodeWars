package java_tests;

class BoolArray {
   /*
   * The reference variables b and x both refer to the same boolean array. count is incremented for each call to the set() method,
   * and once again when the first if test is true. Because of the && short circuit operator, count is not incremented during the second if test.
   * */
   boolean[] b = new boolean[3];
   int count = 0;

   void set(boolean[] x, int i) {
      x[i] = true;
      ++count;
   }

   public static void main(String[] args) {
      Float f = new Float("12");
      System.out.println(f);
      BoolArray ba = new BoolArray();
      ba.set(ba.b, 0);
      ba.set(ba.b, 2);
      ba.test();
   }

   void test() {
      if (b[0] && b[1] | b[2]) {
         count++;
      }
      if (b[1] && b[(++count - 2)]) {
         count += 7;
      }
      System.out.println("count = " + count);
   }
}