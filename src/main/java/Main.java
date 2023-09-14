
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

   public static String battle(String goodAmounts, String evilAmounts) {
      int[] goodSideWorth = new int[]{1, 2, 3, 3, 4, 10};
      int[] intGoodAmounts = Arrays.stream(goodAmounts.split(" ")).mapToInt(Integer::parseInt).toArray();
      int goodSideTotal = 0;
      for (int i = 0; i < goodSideWorth.length; i++) {
         goodSideTotal += goodSideWorth[i] * intGoodAmounts[i];
      }
      int[] evilSideWorth = new int[]{1, 2, 2, 2, 3, 5, 10};
      int[] intEvilAmounts = Arrays.stream(evilAmounts.split(" ")).mapToInt(Integer::parseInt).toArray();
      int evilSideTotal = 0;
      for (int i = 0; i < evilSideWorth.length; i++) {
         evilSideTotal += evilSideWorth[i] * intEvilAmounts[i];
      }

      int battleResult = goodSideTotal - evilSideTotal;

      if (battleResult > 0) {
         return "Battle Result: Good triumphs over Evil";
      }
      else if (battleResult < 0) {
         return "Battle Result: Evil eradicates all trace of Good";
      }
      return "Battle Result: No victor on this battle field";
   }

   public static int[] twoSum(int[] numbers, int target) {
      /*
      Write a function that takes an array of numbers (integers for the tests) and a target number.
      It should find two different items in the array that, when added together, give the target value.
      The indices of these items should then be returned in a tuple / list (depending on your language) like so: (index1, index2).
      * */
      for (int i = 0; i < numbers.length; i++) {
         for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] + numbers[j] == target) {
               return new int[]{i, j};
            }
         }
      }
      return null;
   }

   public static int[][] multiplicationTable(int n) {
      /* Your task, is to create N×N multiplication table, of size provided in parameter.
         For example, when given size is 3: [[1,2,3],[2,4,6],[3,6,9]]
      1 2 3
      2 4 6
      3 6 9
       */
      int[][] result = new int[n][n];
      for (int i = 1; i < n + 1; i++) {
         int[] row = new int[n];
         for (int j = 1; j < row.length + 1; j++) {
            row[j - 1] = i * j;
         }
         result[i - 1] = row;
      }
      return result;
   }

   public static int duplicateCount(String text) {
      /*
      Count the number of Duplicates
      Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
      that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase)
      and numeric digits.

      Example
      "abcde" -> 0 # no characters repeats more than once
      "aabbcde" -> 2 # 'a' and 'b'
      "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
      "indivisibility" -> 1 # 'i' occurs six times
      "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
      "aA11" -> 2 # 'a' and '1'
      "ABBA" -> 2 # 'A' and 'B' each occur twice
      * */
      char[] chars = text.toCharArray();
      Map<Character, Integer> hashMap = new HashMap<>();
      for (char c : chars) {
         char lowerCharKey = Character.toLowerCase(c);
         if (hashMap.containsKey(lowerCharKey)) {
            hashMap.put(lowerCharKey, hashMap.get(lowerCharKey) + 1);
         }
         else {
            hashMap.put(lowerCharKey, 1);
         }
      }
      return hashMap.values().stream().filter(v -> v > 1).toArray().length;
   }

   public static long[] productFibOther(long prod) {
      // https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/java

      long[] result = new long[]{prod, prod};
      long temp;
      long fibNum = prod / 25;
      for (int i = result.length - 1; i >= 0; i--) {
         if (isFibonacci(fibNum)) {
            result[i] = fibNum;
            fibNum = (long) (result[i] / 1.6);
         }
         else {
            i++;
         }
         fibNum--;
      }
      while (result[0] * result[1] > prod) {
         temp = result[0];
         result[0] = result[1] - temp;
         result[1] = temp;
      }
      if (result[0] * result[1] == prod) {
         return new long[]{result[0], result[1], 1};
      }
      else {
         return new long[]{result[1], result[0] + result[1], 0};
      }
   }

   // https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/java
   public static long[] productFib(long prod) {
      long[] result = new long[]{0, 1};
      int index = 2;
      while (result[0] * result[1] < prod) {
         result[0] = result[1];
         result[1] = fib(index);
         index++;
         System.out.println(index - 2);
      }
      if (result[0] * result[1] == prod) {
         return new long[]{result[0], result[1], 1};
      }
      else {
         return new long[]{fib(index - 2), fib(index - 1), 0};
      }
   }
   public static int fib(int n) {
      double sqrt5 = Math.sqrt(5);
      double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
      return (int) Math.round(fibN / sqrt5);
   }

   private static boolean isFibonacci(long n) {
      return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
   }

   private static boolean isPerfectSquare(long x) {
      long s = (long) Math.sqrt(x);
      return (s * s == x);
   }

   public static long[] wetalProductFib(long prod) {
      int first = 0;
      int second = 1;
      while (true) {
         int nextFib = first + second;
         int searchProd = second * nextFib;
         if (searchProd >= prod) {
            if (searchProd == prod) {
               return new long[]{second, nextFib, 1};
            }
            else {
               return new long[]{second, nextFib, 0};
            }
         }
         else {
            first = second;
            second = nextFib;
         }
      }
   }

   private static int recursiveFibonacci(int n) {
      if (n < 2) return n;
      return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
   }

   public static void main(String[] args) {
      long[] result0 = productFib(2932589879121L);
      System.out.println(result0[0] + " " + result0[1] + " " + result0[2]);
//      long[] result = productFib(4895);
//      System.out.println(result[0] + " " + result[1] + " " + result[2]);
//      long[] result2 = productFib(5895);
//      System.out.println(result2[0] + " " + result2[1] + " " + result2[2]);
//      System.out.println(productFib(4895)[0] + " " + productFib(4895)[1]);
//      System.out.println(productFib(5895)[0] + " " + productFib(5895)[1]);
//      System.out.println(duplicateCount("Indivisibility"));
//      multiplicationTable(3);
//      System.out.println(twoSum(new int[]{1, 2, 3}, 4)); // == {0, 2};
//      System.out.println(battle("0 0 0 0 0 10", "0 1 1 1 1 0 0"));
//      System.out.println(incrementString("irv2qa6a/Zbw`mMm/cGX-[ML\\"));
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
