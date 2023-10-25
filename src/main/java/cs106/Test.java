package cs106;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        Instant start = Instant.now();
        Test test = new Test();

//        test.pairClosestToZero(new int[]{-2, 1, 1, 3, 22, 4, 5, 6, 7, 81, 9, -11, 11});
//        test.findIfCharsRepeating("abcdefg");
//        System.out.println(test.average(5,6));
//        System.out.println(test.check("raceacar"));
//        test.process(new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0});
//        System.out.println(test.isAnagram("case", "acse"));
        System.out.println(test.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
        System.out.println("milliseconds time execution : " + timeElapsed);
    }

    public int[] pairClosestToZero(int[] array) {
        int closestToZero = array[0] + array[1];
        int sum;
        int firstIndex = 0;
        int secondIndex = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                sum = array[i] + array[j];
                if (sum == 0) {
                    firstIndex = i;
                    secondIndex = j;
                    int[] result = {array[firstIndex], array[secondIndex]};
                    System.out.println(Arrays.toString(result));
                    return result;
                } else if (sum < 0) {
                    if (sum > closestToZero) {
                        firstIndex = i;
                        secondIndex = j;
                    }
                } else {
                    if (sum < closestToZero) {
                        firstIndex = i;
                        secondIndex = j;
                    }
                }
            }
        }
        int[] result = {array[firstIndex], array[secondIndex]};
        System.out.println(Arrays.toString(result));
        return result;
    }

    public boolean findIfCharsRepeating(String string) {
        Character[] strChars = new Character[string.length()];

        for (int i = 0; i < string.length(); i++) {
            if (Arrays.asList(strChars).contains(string.charAt(i))) {
                return true;
            } else {
                strChars[i] = string.charAt(i);
            }
        }
        return false;
    }

    public static double average(int a, int b) {
        return ((float) a + b) / 2;
    }

    public boolean check(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void process(int[] array) {
        Arrays.sort(array);
        // the 13th endava exercise mySQL
        System.out.println("select name as Department, count(department_id) AS 'Total employee' from departments, employees \n" +
                           "where employees.department_id = departments.id\n" +
                           "group by name;");
    }

    public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        return strToHashMap(str1).equals(strToHashMap(str2));
    }

    private HashMap<Character, Integer> strToHashMap(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if (hashMap.containsKey(key)) {
                int value = hashMap.get(key);
                hashMap.replace(key, value + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        return hashMap;
    }

    private int binarySearch(int[] arr, int num) {
        int lowerBound = 0;
        int upperBound = arr.length;
        int resultNotFound = -1;
        int mid;
        while (lowerBound < upperBound) {
            mid = (upperBound- lowerBound) / 2 + lowerBound;
            if (arr[mid] == num) return mid;
            else if (arr[mid] > num) {
                upperBound = mid;
            } else {
                if ((upperBound - 1) == mid) return -1;
                lowerBound = mid;
            }
        }
        return resultNotFound;
    }
}