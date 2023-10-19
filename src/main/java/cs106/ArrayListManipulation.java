package cs106;

import java.util.ArrayList;

public class ArrayListManipulation {
    public static void main(String[] args) {
        arrayListExample();
    }
    public static void arrayListExample() {

        // ArrayList holds only Non-primitive types (objects)!
        // in this case we use class wrapper Integer (Double, Boolean, Character)
        ArrayList<Integer> intList = new ArrayList<Integer>();
        int x = 5;
        intList.add(x); // autoboxing int x to BoxObject
        int unBoxedInt = intList.get(0); // unboxing BoxObject from intList[0]

        ArrayList<String> strList = new ArrayList<String>();

        strList.add("Qwerty");
        strList.add("qwerty");
        strList.add(0, "fgfhjf"); // inserts a value
        strList.remove(0);
        strList.get(0);
        strList.set(0, "newZeroIndexElem"); // sets a value and return old value
        strList.indexOf("qwerty");
        strList.contains("qwerty");
        strList.isEmpty();

        System.out.println(strList.size());
        System.out.println(strList.contains("qwerty"));
        try {
            System.out.println(strList.get(1));
        } catch (Exception e) {
            System.out.println(e);
        }
        strList.clear();
        System.out.println(strList.isEmpty());
    }
}
