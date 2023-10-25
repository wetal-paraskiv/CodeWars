package cs106;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {
    public static void main(String[] args) {

        HashSet<Integer> integerHashSet = new HashSet<>();
        Set<Integer> integerTreeSet = new TreeSet<>();

        integerHashSet.add(5);
        integerHashSet.add(99);
        integerHashSet.add(7);
        integerHashSet.add(8);
        integerHashSet.add(1);
        integerHashSet.add(2);
        System.out.println("can I add unique values in a Set ? - " + integerHashSet.add(3));
        System.out.println("can I add not unique values ? - " + integerHashSet.add(3));
        integerHashSet.add(6);

        System.out.println("size of HashSet-Class which implements Set Interface methods... : " + integerHashSet.size());
        System.out.println(integerHashSet);

        Iterator<Integer> iterator = integerHashSet.iterator();
        while (iterator.hasNext()) {
            int hashSetNum = iterator.next();
            if (hashSetNum != 5) {
                System.out.println(hashSetNum + " Not a FIVE yet!");
            } else {
                System.out.println("Ohh, a FIVE!!!");
                break;
            }
        }

        for (int x: integerHashSet
             ) {
            integerTreeSet.add(x);
        }
        System.out.println(integerTreeSet);
    }
}
