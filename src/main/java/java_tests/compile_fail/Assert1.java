package java_tests.compile_fail;

public class Assert1 {

   public void foo()
   {
      assert false; /* Line 5 */
      assert false; /* Line 6 */
   }
   public void bar()
   {
      while(true)
      {
         assert false; /* Line 12 */
         break; // added for compile
      }
      assert false;  /* Line 14 */
   }
}
