package leet_code;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;


public class LeetCode {

    public static void main(String[] args) {
        Instant start = Instant.now();
        LeetCode leetCode = new LeetCode();

//        System.out.println(leetCode.isPalindrome(11235211));
//        System.out.println(leetCode.romanToInt("MCMXCIV"));
//        System.out.println(leetCode.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
//        System.out.println(leetCode.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
//        System.out.println(leetCode.removeElement(new int[]{3, 2, 2, 3}, 3));
//        System.out.println(leetCode.removeElement(new int[]{1}, 1));
//        System.out.println(leetCode.strStr("hello", ""));
//        int[] myArray = new int[1000000000];
//        for (int i = 0; i < myArray.length; i++) {
//            myArray[i] = i;
//        }
//        System.out.println(leetCode.searchInsert(myArray, 1000000000 - 1));
//        System.out.println(leetCode.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(leetCode.maxSubArray(new int[]{1}));
//        System.out.println(leetCode.maxSubArray(new int[]{5, 4, -1, 7, 8}));
//        System.out.println(leetCode.maxSubArray1(new int[]{5, 4, -1, 7, 8}));
//        System.out.println(leetCode.maxSubArray(new int[]{-2, 1}));
//        System.out.println(leetCode.maxSubArray1(new int[]{-2, 1}));
//        System.out.println(leetCode.maxSubArray(new int[]{-2, -1, -5}));
//        System.out.println(leetCode.maxSubArray1(new int[]{-2, -1, -5, 7, -3, 100}));
//        System.out.println(leetCode.lengthOfLastWord("      Hello     World                          "));
//        System.out.println(Arrays.toString(leetCode.plusOne(new int[]{9, 9})));
//        System.out.println(Arrays.toString(leetCode.plusOne(new int[]{8, 9, 9, 9})));
//        System.out.println(Arrays.toString(leetCode.plusOne(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6})));
//        System.out.println(leetCode.addBinary("11", "1"));
//        System.out.println(leetCode.addBinary(
//                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
//                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
//        System.out.println(leetCode.mySqrt(6));
//        System.out.println(leetCode.mySqrt(8));
//        System.out.println(leetCode.mySqrt(9));
//        System.out.println(leetCode.mySqrt(400000));
//        System.out.println(leetCode.climbStairs(4));
//        leetCode.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//        leetCode.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);



        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
        System.out.println("time execution: " + timeElapsed);
    }

    public boolean isPalindrome(int x) {
        String strNumber = String.valueOf(x);
        for (int i = 0; i < strNumber.length() / 2; i++) {
            if (strNumber.charAt(i) == strNumber.charAt(strNumber.length() - 1 - i)) {
                continue;
            } else return false;
        }
        return true;
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && dict.get(s.charAt(i)) < dict.get(s.charAt(i + 1))) {
                result += dict.get(s.charAt(i + 1)) - dict.get(s.charAt(i));
                i++;
            } else result += dict.get(s.charAt(i));
        }

        return result;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int counter = 0;
        for (int i = 0; i < nums.length - counter - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
                counter += 1;
                i--;
            }
        }
        return nums.length - counter;
    }

    public int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length - counter; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
                counter += 1;
                i--;
            }
        }
        return nums.length - counter;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int searchInsert(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length; i++) {
//            if (target <= numbers[i]) return i;
//        }
//        return numbers.length;

        int downBound = 0;
        int upperBound = numbers.length;
        int index = (upperBound + downBound) / 2;
        int stopFlagIfNumNotInArray;
        while (numbers[index] != target) {
            if (numbers[index] < target) {
                downBound = index;
            } else {
                upperBound = index;
            }
            stopFlagIfNumNotInArray = index;
            index = (upperBound + downBound) / 2;
            if (stopFlagIfNumNotInArray == index) return upperBound;
        }
        return index;
    }

    public int maxSubArray(int[] nums) {
        // my brute force...
        int max;
        int sum;
        int bound;
        if (nums.length > 0) {
            max = nums[0];
        } else max = 0;
        for (int i = 0; i < nums.length; i++) {
            bound = i;
            while (bound != nums.length) {
                sum = 0;
                for (int j = i; j <= bound; j++) {
                    sum += nums[j];
                }
                if (sum > max) max = sum;
                bound += 1;
            }
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        // and a real solution = Kadane's Algorithm
        // the catch: if at any point sum becomes negative then no point keeping it because
        // 0 is obviously greater than negative, so just make your sum 0.
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;
    }

    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }

    public int[] plusOne(int[] digits) {
        String strDigits = "";
        for (int i = 0; i < digits.length; i++) {
            strDigits += digits[i];
        }
        BigInteger plusOneResult = new BigInteger(strDigits).add(new BigInteger("1"));
        return Stream.of(String.valueOf(plusOneResult).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public String addBinary(String a, String b) {
        BigInteger sum = new BigInteger(a, 2).add(new BigInteger(b, 2));
        return sum.toString(2);
    }

    public int binaryToInteger(String str) {
        System.out.println(str.length());
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result += Math.pow(2, i);
            }
        }
        return result;
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int lowerBound = 0;
        int upperBound = x;
        int guess = (upperBound + lowerBound) / 2;
        int stopCheck = guess;
        while (true) {
            if (Math.pow(guess, 2) > x) {
                upperBound = guess;
            } else {
                lowerBound = guess;
            }
            guess = (upperBound + lowerBound) / 2;
            if (guess == stopCheck) break;
            else stopCheck = guess;
        }
        return guess;
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
//        for (int i = 0; i < m + n; i++) {
//            int min = nums1[i];
//            for (int j = i + 1; j < m + n; j++) {
//                if (nums1[j] < min) {
//                    int temp = nums1[i];
//                    nums1[i] = nums1[j];
//                    nums1[j] = temp;
//                    min = nums1[i];
//                    j--;
//                }
//            }
//        }
        System.out.println(Arrays.toString(nums1));
    }


}
