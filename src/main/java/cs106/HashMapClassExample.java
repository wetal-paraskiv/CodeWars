package cs106;

import java.util.*;

public class HashMapClassExample {
    public static void main(String[] args) {

        // for single thread, not synchronized, allows one null key
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("USA", "Washington DC");
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");

        // for multiple threads, synchronized, doesn't allow any null key
        Hashtable<String, String> hashtableCities = new Hashtable<>();

        // will be sorted based on the natural ordering of keys or with a Custom comparator.
        TreeMap<String, String> treeCapitalCities = new TreeMap<>(Comparator.reverseOrder());
        treeCapitalCities.put("USA", "Washington DC");
        treeCapitalCities.put("England", "London");
        treeCapitalCities.put("Germany", "Berlin");
        treeCapitalCities.put("Norway", "Oslo");

        // keeping the insertion order
        LinkedHashMap<String, String> insertionOrderedCapitalCities = new LinkedHashMap<>();
        insertionOrderedCapitalCities.put("USA", "Washington DC");
        insertionOrderedCapitalCities.put("England", "London");
        insertionOrderedCapitalCities.put("Germany", "Berlin");
        insertionOrderedCapitalCities.put("Norway", "Oslo");

/*
        capitalCities.remove("Germany");
        System.out.println(capitalCities.containsKey("England"));

        // all keys from HashMap Collection
        for (String strKey : capitalCities.keySet()) {
            System.out.println("Key: " + strKey);
        }

        // all values from HashMap Collection
        for (String value : capitalCities.values()) {
            System.out.println("Value: " + value);
        }
**/
        // all (keys & values) from HashMap Collection iterating over keys
        for (String key : capitalCities.keySet()) {
            System.out.println("key: " + key + " & value: " + capitalCities.get(key));
            hashtableCities.put(key, capitalCities.get(key));
        }

        System.out.println("Whole HashMap:\t" + capitalCities);
        System.out.println("Size of: " + capitalCities.size());

        // using Iterator
        System.out.println("listing capitalCities entries using iterator:");
        Iterator<String> iterator = capitalCities.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("\t" + capitalCities.get(iterator.next()));
        }

        // all entries using entrySet()
        for (Map.Entry<String, String> entry : hashtableCities.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue() + "\twhole entry: " + entry);
        }
        for (Map.Entry<String, String> entry : insertionOrderedCapitalCities.entrySet()) {
            System.out.println(entry);
        }
        for (Map.Entry<String, String> entryElement : treeCapitalCities.entrySet()) {
            System.out.println(entryElement);
        }

//        Iterator<String> hashtableIterator = hashtableCities.keySet().iterator();
//        while (hashtableIterator.hasNext()) {
//            System.out.println(hashtableIterator);
//        }
    }
}