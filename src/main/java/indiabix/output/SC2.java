package indiabix.output;

class SC2 {
   /*
   * What will be the output of the program ?
   *
9 7 7 foo 7 7foo

72 34 34 foo34 34foo

9 7 7 foo34 34foo

72 7 34 foo34 7foo
*
   * */
   public static void main(String[] args) {
      SC2 s = new SC2();
      s.start();
   }

   void start() {
      int a = 3;
      int b = 4;
      System.out.print(" " + 7 + 2 + " ");
      System.out.print(a + b);
      System.out.print(" " + a + b + " ");
      System.out.print(foo() + a + b + " ");
      System.out.println(a + b + foo());
   }

   String foo() {
      return "foo";
   }
}