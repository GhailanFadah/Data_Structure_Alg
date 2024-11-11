
/*
Author: Ghailan Fadah
Course: 231
class: Customer
Date: 10/30/21
Description: creates and implends the Mapset interface to create BST tree
*/

import java.util.ArrayList;
import java.util.Comparator;

public class BSTMap<K, V> implements MapSet<K, V> {

        // fields for the class
        private TNode<K, V> root;
        private Comparator<K> comp;

        // constructor: takes in a Comparator object
        public BSTMap(Comparator<K> comp) {
                this.root = null;
                this.comp = comp;

        }

        /*
         * adds or updates a key-value pair. If there is already a pair with new_key in
         * the map, then update the pair's value to new_value. If there is not already a
         * pair with new_key, then add pair with new_key and new_value. returns the old
         * value or null if no old value existed
         */
        public V put(K key, V value) {

                // check for and handle the special case
                if (this.root == null) {
                        this.root = new TNode<K, V>(key, value);

                        return null;
                }

                // call the root node's put method
                return this.root.put(key, value, comp);

        }

        // gets the value at the specified key or null
        public V get(K key) {

                // check for and handle the special case
                if (this.root == null) {
                        return null;
                }

                // call the root node's get method
                return this.root.get(key, comp);

        }

        // checks to see if the tree contains the given key
        // returns true if it contains it or false if it does not
        public boolean containsKey(K key) {

                // check for and handle the special case
                if (this.root == null) {
                        return false;
                }

                // call the root node's containsKey method
                return this.root.containsKey(key, comp);
        }

        // returns an ArrayList of all the keys in the tree
        public ArrayList<K> keySet() {

                // creates an ArrayList that hold type K
                ArrayList<K> kList = new ArrayList<K>();

                // calls the root keySet method if it is not null
                // passes the list as a parameter
                if (this.root != null) {
                        // creates a new arraylist of type K and sets it equal
                        // to the roots keySet method
                        ArrayList<K> keySet = this.root.keySet(kList);

                        // returns the list
                        return keySet;

                }

                // returns null if root is null
                return null;

        }

        // returns an ArrayList of all the values in the tree
        public ArrayList<V> values() {

                // creates an arraylist that holds type V
                ArrayList<V> vList = new ArrayList<V>();

                // if the root is not null loops over every key in the key ArrayList and
                // add its value to the value ArrayList
                if (this.root != null) {
                        for (K k : keySet()) {
                                V v = this.get(k);
                                vList.add(v);
                        }

                        // return the value ArrayList
                        return vList;
                }

                // return null if the root is null
                return null;

        }

        // returns an Arraylist of all the key value pairs in the tree
        public ArrayList<KeyValuePair<K, V>> entrySet() {

                // if the root is null return null
                if (this.root == null) {
                        return null;
                }

                // create an ArrayList of type key value pairs
                ArrayList<KeyValuePair<K, V>> pList = new ArrayList<KeyValuePair<K, V>>();

                // calls the root's entrySet method
                return this.root.entrySet(pList);
        }

        // returns the size of the tree
        public int size() {

                // returns the size of the key ArrayList
                return this.keySet().size();
        }

        // clears the map by resetting fields
        public void clear() {

                this.root = null;
        }

        // node class
        private class TNode<K, V> {

                // need fields for the left and right children
                private TNode<K, V> right;
                private TNode<K, V> left;

                // need a KeyValuePair to hold the data at this node
                private KeyValuePair<K, V> pair;

                // constructor, given a key and a value
                public TNode(K k, V v) {

                        // initialize all of the TNode fields
                        pair = new KeyValuePair<K, V>(k, v);
                        this.right = null;
                        this.left = null;
                }

                /*
                 * Takes in a key, a value, and a comparator and inserts // the TNode in the
                 * subtree rooted at this node. Returns the value associated with the key in the
                 * subtree rooted at this node or null if the key does not already exist
                 */
                public V put(K key, V value, Comparator<K> comp) {

                        // if the key and the node key are equal return the old value and insert new
                        // value at key
                        if (comp.compare(this.pair.getKey(), key) == 0) {
                                V oldVal = this.pair.getValue();
                                this.pair.setValue(value);
                                return oldVal;
                        }

                        // if the key is less than the key at this node
                        // either create a new node as its left child if its currently null
                        // or class the method on the left child. recursive
                        if (comp.compare(key, this.pair.getKey()) < 0) {
                                if (this.left == null) {
                                        this.left = new TNode<K, V>(key, value);
                                        return null;
                                }

                                return this.left.put(key, value, comp);

                        }

                        // since its not equal to node's key or less than its left child key it must be
                        // greater
                        // either create a new node as its right child if its currently null
                        // or class the method on the right child. recursive
                        if (this.right == null) {
                                this.right = new TNode<K, V>(key, value);
                                return null;
                        }

                        return this.right.put(key, value, comp);

                }

                // Takes in a key and a comparator
                // Returns the value associated with the key or null
                public V get(K key, Comparator<K> comp) {

                        // if the key at the node is equal to key then return the value tagged with the
                        // key
                        if (comp.compare(this.pair.getKey(), key) == 0) {
                                return this.pair.getValue();
                        }

                        // if the key at the node is greater than key then return and the left child is
                        // not null call recursive method on it.
                        if (comp.compare(key, this.pair.getKey()) < 0) {
                                if (this.left != null) {
                                        return this.left.get(key, comp);
                                }

                        }

                        // last option is to call the recursive method on the right child if it is not
                        // null
                        if (this.right != null) {
                                return this.right.get(key, comp);
                        }

                        // return null if not found
                        return null;
                }

                public boolean containsKey(K key, Comparator<K> comp) {

                        // if the key is equal to the node's key return true
                        if (comp.compare(this.pair.getKey(), key) == 0) {
                                return true;
                        }

                        // if key is less than node's key call the recursive method on the left child if
                        // it is not null
                        if (comp.compare(key, this.pair.getKey()) < 0) {

                                if (this.left == null) {
                                        return false;
                                }
                                return this.left.containsKey(key, comp);

                        }

                        // call the recursive method on the right child if it is not null
                        if (this.right == null) {
                                return false;
                        }
                        return this.right.containsKey(key, comp);

                }

                // returns an arraylist of K
                public ArrayList<K> keySet(ArrayList<K> list) {

                        // adds the key at the node
                        list.add(this.pair.getKey());

                        // if node has a left child call the recursive method on it
                        if (this.left != null) {
                                this.left.keySet(list);
                        }

                        // if node has a right child call the recursive method on it
                        if (this.right != null) {
                                this.right.keySet(list);
                        }

                        // return list
                        return list;

                }

                // returns an ArrayList of key value pairs
                public ArrayList<KeyValuePair<K, V>> entrySet(ArrayList<KeyValuePair<K, V>> list) {

                        // adds the pair at this node
                        list.add(this.pair);

                        // if node has a left child call the recursive method on it
                        if (this.left != null) {
                                this.left.entrySet(list);
                        }

                        // if node has a right child call the recursive method on it
                        if (this.right != null) {
                                this.right.entrySet(list);
                        }

                        // return list
                        return list;

                }

                public String toString() {

                        return " ";
                }

        }

        // testing code
        public static void main(String[] argv) {

                BSTMap<String, Integer> bst = new BSTMap<String, Integer>(new AscendingString());

                bst.put("twenty", 20);
                bst.put("ten", 10);
                bst.put("eleven", 11);
                bst.put("five", 5);
                bst.put("six", 6);

                System.out.println(bst.get("eleven"));
                System.out.println(bst.containsKey("five"));
                System.out.println(bst.get("eleven"));
                // System.out.println(bst.values());
                System.out.println(bst.entrySet());

        }

}
