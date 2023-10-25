package indiabix;

public class BitDecimal {

    /*
     * Bitwise AND (&) This operator is a binary operator, denoted by ‘&.’
     * It returns bit by bit AND of input values, i.e., if both bits are 1, it gives 1, else it shows 0.
     *
     * Bitwise OR (|) This operator is a binary operator, denoted by ‘|’.
     * It returns bit by bit OR of input values, i.e., if either of the bits is 1, it gives 1, else it shows 0.
     *
     * Bitwise XOR (^) This operator is a binary operator, denoted by ‘^.’
     * It returns bit by bit XOR of input values, i.e., if corresponding bits are different, it gives 1, else it shows 0.
     *
     * Bitwise Complement (~) This operator is a unary operator, denoted by ‘~.’
     * It returns the one’s complement representation of the input value, i.e., with all bits inverted,
     * which means it makes every 0 to 1, and every 1 to 0.
     * */

    public static void main(String[] args) {

//        System.out.println((11) & (9));
//        System.out.println(9 ^ 3);
//        System.out.println(10 | 12);
//        System.out.println((60) & (13));
//        System.out.println(bitWiseANDOperator(60, 13));
//
//        System.out.println(10 | 12);
//        System.out.println(true | true);
//        int x = 1, y = 6;
//        System.out.println(Math.pow(2, 16) - 1);
//        System.out.println(5 | 7);
//        System.out.println(bitWiseOROperator(5, 7));
//
//        System.out.println(9 ^ 3);
//        System.out.println(5 ^ 7);
//        System.out.println(bitWiseXOROperator(5, 7));
//

        System.out.println(1 % 2);
//        System.out.println(decimalToBit(5));
//        System.out.println(bitToDecimal(decimalToBit(256)));
//        System.out.println(~ 5);
//        System.out.println(bitWiseComplementOperator(5));
    }

    public static String decimalToBit(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            int bit = num % 2;
            stringBuilder.append(bit);
            num = num / 2;
        }
        int zerosToAdd = 4 - stringBuilder.toString().length();
        for (int i = 0; i < zerosToAdd; i++) {
            stringBuilder.append(0);
        }
        return stringBuilder.reverse().toString();
    }

    public static int bitToDecimal(String bitStr) {
        int result = 0;
        for (int i = 0; i < bitStr.length(); i++) {
            result = (int) (result +
                    Character.getNumericValue(bitStr.charAt(bitStr.length() - 1 - i)) * Math.pow(2, i));
        }
        return result;
    }

    public static int bitWiseANDOperator(int num1, int num2) {
        String bitNum1 = decimalToBit(num1);
        String bitNum2 = decimalToBit(num2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bitNum1.length(); i++) {
            if (bitNum1.charAt(i) == bitNum2.charAt(i)) {
                stringBuilder.append(bitNum1.charAt(i));
            } else {
                stringBuilder.append(0);
            }
        }
        return bitToDecimal(stringBuilder.toString());
    }

    public static int bitWiseOROperator(int num1, int num2) {
        String bitNum1 = decimalToBit(num1);
        String bitNum2 = decimalToBit(num2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bitNum1.length(); i++) {
            if (bitNum1.charAt(i) == '1' || bitNum2.charAt(i) == '1') {
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
        }
        return bitToDecimal(stringBuilder.toString());
    }

    public static int bitWiseXOROperator(int num1, int num2) {
        String bitNum1 = decimalToBit(num1);
        String bitNum2 = decimalToBit(num2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bitNum1.length(); i++) {
            if (bitNum1.charAt(i) != bitNum2.charAt(i)) {
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
        }
        return bitToDecimal(stringBuilder.toString());
    }

    public static int bitWiseComplementOperator(int num) {
        String bitNum = decimalToBit(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bitNum.length(); i++) {
            if (bitNum.charAt(i) == '0') {
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
        }
        return bitToDecimal(stringBuilder.toString());
    }

}


