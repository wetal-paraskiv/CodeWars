package cs106;

public class CharManipulation {
    public static void main(String[] args) {
        System.out.println(charToLowerCase('F'));
        charsLoopStepTwo();
        checkChar('c');
    }

    public static char charToLowerCase(char ch) {
        // checking if ch is a UpperCase character
        if ((ch >= 'A') && (ch <= 'Z')) {
            return (char) ((ch - 'A') + 'a');
        }
        System.out.format("%1$s is not an UpperCase Letter\n", ch);
        return ch;
    }

    public static void charsLoopStepTwo() {
        for (char ch = 'A'; ch < 'Z'; ch += 2) {
            // casting char to corresponding number
            System.out.println(ch + ": " + (int) ch);
        }
    }

    public static void checkChar(char ch) {
        System.out.println("The char is digit: " +
                           Character.isDigit(ch));
        System.out.println("The char is letter: " +
                           Character.isLetter(ch));
        System.out.println("The char is letter or digit: " +
                           Character.isLetterOrDigit(ch));
        System.out.println("The char is lowerCase: " +
                           Character.isLowerCase(ch));
        System.out.println("The char is upperCase: " +
                           Character.isUpperCase(ch));
        System.out.println("The char is whitespace tab or \\n: " +
                           Character.isWhitespace(ch));
    }
}
