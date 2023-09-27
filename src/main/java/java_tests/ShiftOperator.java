package java_tests;

public class ShiftOperator {

   public static void main(String[] args) {
      System.out.println("binary: " + Integer.toBinaryString(3));
      System.out.println("binary: " + Integer.toBinaryString(3 << 2));
      System.out.println(3 >> 1);
      System.out.println("binary: " + Integer.toBinaryString(3 >> 1));
      System.out.println("binary: " + Integer.toBinaryString(12));

   }
}
