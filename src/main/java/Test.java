import java.util.ArrayList;

public class Test {
   // https://www.indiabix.com/online-test/java-programming-test/



   public static void main(String[] args) {

      Boolean b1 = new Boolean("TRUE");
      Boolean b2 = new Boolean("true");
      Boolean b3 = new Boolean("tRuE");
      Boolean b4 = new Boolean("false");
      System.out.println(b4);
   }
}


interface Base
{
   boolean m1 ();
   byte m2(short s);
}
abstract class Class2 implements Base {}
