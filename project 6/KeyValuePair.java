/*
Author: Ghailan Fadah
Course: 231
class: Customer
Date: 10/30/21
Description: creates pair that holds a key and a value 
*/

public class KeyValuePair<Key, Value> {

    // fields for the class
    protected Key key;
    protected Value val;

    // default constructor
    public KeyValuePair(Key k, Value v) {
        this.key = k;
        this.val = v;
    }

    // getter for the key field
    public Key getKey() {
        return this.key;
    }

    // getter for the value field
    public Value getValue() {
        return this.val;
    }

    // setter for the value field
    public void setValue(Value v) {
        this.val = v;
    }

    // toString method: returns the key and value seprated by a space
    public String toString() {
        String result = "";

        result += this.key + " " + this.val;

        return result;
    }

    // testing area
    public static void main(String[] args) {

        KeyValuePair pair = new KeyValuePair<Integer, Integer>(4, 5);

        System.out.println(pair);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
        pair.setValue(30);

        System.out.println(pair);
    }

}
