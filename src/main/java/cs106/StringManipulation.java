package cs106;

import java.util.StringTokenizer;

public class StringManipulation {
    public String strToUpperCase(String str) {
//        String newStr =  str.toUpperCase();
        str = str.toUpperCase();
        return str;
    }

    public boolean isStringContentEqual(String str) {
        String s1 = "Qwerty";
//        return s1 == str;
//        return s1.equals((str));
        return s1.equalsIgnoreCase((str));
    }

    // Strings are immutable
    // equals
    // substring
    // compareTo
    // indexOf (char or substring)
    public char charAt(String str, int index) {
        return str.charAt(index);
    }

    public void stringTokenizer() {
        String str = "public, boolean is.String;ContentEqual(String str) ";
        StringTokenizer tokenizer = new StringTokenizer(str, ",. ;()");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    public String encryptCaesar(String str, int key) {
        String encryptedStr = "";
        if (key < 0) {
            key = 26 - (-key % 26);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            encryptedStr += encrypt(ch, key);
        }
        return encryptedStr;
    }

    private char encrypt(char ch, int key) {
        if (Character.isLetter(ch)) {
            if (Character.isUpperCase(ch)) {
                return (char) ('A' + (ch - 'A' + key) % 26);
            } else {
                return (char) ('a' + (ch - 'a' + key) % 26);
            }
        }
        return ch;
    }

}