import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

   public static String getMiddle(String word) {
      int index = word.length() / 2;
      if (word.length() % 2 != 0) {
         return String.valueOf(word.charAt(index));
      }
      else {
         return "" + word.charAt(index - 1) + word.charAt(index);
      }
   }

   static String toCamelCase(String s) {
      if (s.isEmpty()) return s;
      String result = "";
      for (String str : s.split("[_-]")) {
         result += str.substring(0, 1).toUpperCase() + str.substring(1);
      }
      String str = Character.isUpperCase(s.charAt(0)) ? result : s.substring(0, 1) + result.substring(1);
      return str;
   }

   public static boolean isNarcissistic(int number) {
      int power = String.valueOf(number).length();
      return number == Arrays.stream(String.valueOf(number).split(""))
         .mapToInt(Integer::parseInt)
         .mapToDouble(n -> Math.pow(n, power))
         .sum();
//      int processedNum = 0;
//      String strNum = String.valueOf(number);
//      int power = strNum.length();
//      for (String s: strNum.split(""))
//      {
//         processedNum += Math.pow(Integer.parseInt(s), power);
//      }
//      return number == processedNum;
   }

   public static boolean isIsogram(String str) {
      return str.length() == Arrays.stream(str.split(""))
         .map(s -> s.toLowerCase())
         .collect(Collectors.toSet())
         .size();
   }

   public static Map<Character, Integer> count(String str) {
      Map<Character, Integer> result = new HashMap<>();
      if (!str.isEmpty()) {
         for (char c : str.toCharArray()) {
            if (result.containsKey(c)) {
               result.put(c, result.get(c) + 1);
            }
            else {
               result.put(c, 1);
            }
         }
         return result;
      }
      return result;
   }

   public static String incrementString(String str) {
      if (str.isEmpty()) return "1";
      if (!Character.isDigit(str.charAt(str.length() - 1))) return str + "1";
      int index = 0;
      for (int i = str.length() - 1; i > -1; i--) {
         if (Character.isDigit(str.charAt(i))) {
            index = i;
         }
         else {
            break;
         }
      }
      String numToChange = str.substring(index);
      StringBuilder changedNum = new StringBuilder(String.valueOf(new BigInteger(numToChange).add(BigInteger.valueOf(1))));
      int numOfZerosToAdd = numToChange.length() - changedNum.length();
      for (int j = 0; j < numOfZerosToAdd; j++) {
         changedNum.insert(0, "0");
      }
      return str.substring(0, index) + changedNum;
   }

   public static void main(String[] args) {
      System.out.println(incrementString("irv2qa6a/Zbw`mMm/cGX-[ML\\"));
//      System.out.println(incrementString("^PpSMxjZ[(Jkxf32040144114356511532529311443003"));
//      System.out.println(incrementString("2@FA-(h-;se)mQ$&IK19251222172957913"));
//      System.out.println(incrementString("999"));
//      System.out.println(incrementString(""));
//      System.out.println(incrementString("foo"));
//      System.out.println(incrementString("foobar99"));
//      System.out.println(incrementString("foobar099"));
//      System.out.println(incrementString("foobar001"));
//      System.out.println(incrementString("foobar1"));
//      System.out.println(incrementString("JTHwYuf3>OXQL4ClX/n,QeLGMoS$PqP000000003669"));
   }
}
