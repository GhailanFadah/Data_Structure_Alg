/*
Author: Ghailan Fadah
Course: 231
class: Hashmap
Date: 11/14/21
Description: creates and implends the Mapset interface to create a hashmap
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Math;

public class Hashmap<K, V> implements MapSet<K, V> {

    // Node class
    public class HashNode<K, V> {

        // fields for node class
        private KeyValuePair<K, V> pair;
        private HashNode<K, V> next;

        // constructor for node class
        public HashNode(K key, V value) {
            pair = new KeyValuePair<K, V>(key, value);
            this.next = null;
        }
    }

    // fields for the hashmap
    private HashNode<K, V>[] hashTable = null;
    private int tableSize = 16;
    private int filled = 0;
    private int collisions = 0;
    private Comparator<K> comp;

    // Hashmap constructor that starts with default size hash table
    public Hashmap(Comparator<K> incomp) {
        this.hashTable = new HashNode[tableSize];

        this.comp = incomp;
    }

    // Hashmap constructor that starts with the suggecsted capacity hash table
    public Hashmap(Comparator<K> incomp, int capacity) {
        this.hashTable = new HashNode[capacity];

        this.comp = incomp;
    }

    // hash function
    private int hash(K key) {

        return Math.abs(key.hashCode() % this.tableSize);
    }

    // hashes an item to the hashmP
    public V put(K newKey, V newValue) {

        // checks to see if the table is 1/3 fillled
        // if so creates a table twice the size and copties all the data to it
        if (this.filled > this.tableSize / 3) {
            ArrayList<KeyValuePair<K, V>> data = this.entrySet();

            HashNode<K, V>[] temp = new HashNode[this.tableSize * 2];
            this.tableSize *= 2;
            this.hashTable = temp; // Extension: lose referance to the old hashtable object
            this.filled = 0;
            this.collisions = 0;

            // loops over the old table to get each data from it
            for (int i = 0; i < data.size(); i++) {
                this.put(data.get(i).getKey(), data.get(i).getValue());
            }

        }

        // creates an index for the new key
        int position = hash(newKey);

        // creates a node at that index
        HashNode<K, V> current = hashTable[position];

        // checks to see if that index is null
        // if so, creates a new node there with the key and value
        // increases filled by one
        if (current == null) {
            hashTable[position] = new HashNode<K, V>(newKey, newValue);
            this.filled++;
            return null;

            // starts a while loop that loops until it either reaches a null node or a node
            // with the same key as the one given
        } else {
            while (current.next != null && comp.compare(current.pair.getKey(), newKey) != 0) {
                current = current.next;
            }

            // if a node with the key is found than change its value to the new value and
            // return the old value for the key
            if (comp.compare(current.pair.getKey(), newKey) == 0) {
                V oldVal = current.pair.getValue();
                current.pair.setValue(newValue);
                return oldVal;

                // else create a new node with the given key and value
                // increase filled and collisions by one
            } else {
                current.next = new HashNode<K, V>(newKey, newValue);
                this.filled++;
                collisions++;

            }

        }

        // return null
        return null;

        // Extension: lose referance to current node object created for this method
    }

    // checks if a key is in the hashmap or not: returns either true or false
    public boolean containsKey(K key) {

        // hashes the key
        int position = this.hash(key);

        // creates a node at that position
        HashNode<K, V> current = hashTable[position];

        // starts a while loop that loops until it either reaches a null node or a node
        // with the same key as the one given
        while (current != null && comp.compare(key, current.pair.getKey()) != 0) {
            current = current.next;
        }

        // if no node with the key is found return false
        if (current == null) {
            return false;
        }

        // if a key is found return true
        if (comp.compare(current.pair.getKey(), key) == 0) {
            return true;

        }

        // return false
        return false;

        // Extension: lose referance to current node object created for this method
    }

    // gets the value linked with the key
    public V get(K key) {

        // hashes the key
        int position = this.hash(key);

        // creates a node at that position
        HashNode<K, V> current = hashTable[position];

        // starts a while loop that loops until it either reaches a null node or a node
        // with the same key as the one given
        while (current != null && comp.compare(current.pair.getKey(), key) != 0) {
            current = current.next;
        }

        // if no node with the key is found return false
        if (current == null) {
            return null;
        }

        // if a key is found return its value
        if (comp.compare(current.pair.getKey(), key) == 0) {
            return current.pair.getValue();
        }

        // return null
        return null;

        // Extension: lose referance to current node object created for this method
    }

    // returns an Arraylist of the keys
    public ArrayList<K> keySet() {

        // creates an arrayList
        ArrayList<K> list = new ArrayList<K>();

        // loops over the entire table and sets current equal to the node at that index
        for (int i = 0; i < this.tableSize; i++) {
            HashNode<K, V> current = hashTable[i];

            // gets all the keys and adds them to the list
            while (current != null) {
                list.add(current.pair.getKey());
                current = current.next;
            }
        }

        // returns the list
        return list;

        // Extension: lose referance to current node object created for this method
    }

    // returns an Arraylist of the values
    public ArrayList<V> values() {

        // creates an arrayList
        ArrayList<V> list = new ArrayList<V>();

        // loops over the entire table and sets current equal to the node at that index
        for (int i = 0; i < this.tableSize; i++) {
            HashNode<K, V> current = hashTable[i];

            // gets all the values and adds them to the list
            while (current != null) {
                list.add(current.pair.getValue());
                current = current.next;
            }
        }

        // returns list
        return list;

        // Extension: lose referance to current node object created for this method
    }

    // returns an ArrayList of keyValue pairs
    public ArrayList<KeyValuePair<K, V>> entrySet() {

        // creates an arrayList
        ArrayList<KeyValuePair<K, V>> list = new ArrayList<KeyValuePair<K, V>>();

        // loops over the entire table and sets current equal to the node at that index
        for (int i = 0; i < this.tableSize; i++) {
            HashNode<K, V> current = hashTable[i];

            // gets all the keyValuePairs and adds them to the list
            while (current != null) {
                list.add(current.pair);
                current = current.next;
            }
        }

        // returns list
        return list;

        // Extension: lose referance to current node object created for this method
    }

    // returns the size of the hashmap
    public int size() {

        return this.keySet().size();
    }

    // clears the map
    public void clear() {

        this.hashTable = new HashNode[this.tableSize];

        // Extension: lose referance to the old hashtable object
    }

    // toString method
    public String toString() {
        String result = "";

        // for(int i = 0; i < this.tableSize; i++){

        // HashNode<K, V> current = hashTable[i];

        // while(current != null){
        // result += current.pair.getKey() + "=" + current.pair.getValue() + ", ";
        // current = current.next;
        // }
        // }

        // return result;

        result += this.getCollisions();

        return result;
    }

    // returns the number of collisions
    public int getCollisions() {
        return this.collisions;
    }

    // test area
    public static void main(String[] args) {

        Hashmap<String, Integer> map = new Hashmap<>(new AscendingString());

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("Four", 5);
        System.out.println(map);

        map.put("two", 6);
        System.out.println(map);
        System.out.println(map.collisions);
    }

}